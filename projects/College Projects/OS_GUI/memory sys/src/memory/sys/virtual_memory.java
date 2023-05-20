/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory.sys;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author noureldin
 */
public class virtual_memory {
    private Page add_trans;
    public static RAM mem;
    public static int MAX = 1 << 20,seg_size = 1 << 5;
    private static int ctr = 0;
    private int id;
    private HashMap<Integer,frame> map;
    public virtual_memory(){
        add_trans = new Page();
        map = new HashMap<>();
        id = ctr++;
    }
    public frame get_address(int p){
        if(map.containsKey(p)) return map.get(mem);
        else return null;
    }
    public void write(int p,int value) throws Exception{
        frame add = get_address(p);
        if(add.get_access() == id){
            mem.write(add.get_base() + p,value);
        }
        else throw new Exception("unauthorized to write in this place");
    }
    public Integer read(int p){
        frame add = get_address(p);
        return mem.read(add.get_base() + p);
    }
    public void add_adress(int a,int b) throws Exception{
        map.put(a, add_trans.get_frame(b));
        if(map.get(a) == null){
            if(mem.taken_frame(new frame(b - b%seg_size,b%seg_size,1))) throw new Exception("unauthorized to write in this place");
            map.put(a, new frame(b - b%seg_size,b%seg_size,1));
            add_trans.insert(map.get(a));
            mem.write(b, 0);
        }
    }
    public void free(){
        add_trans.free();
    }
    public LinkedList<frame> get_all(){
        return add_trans.get_all();
    }
    public int get_id(){
        return id;
    }
}
