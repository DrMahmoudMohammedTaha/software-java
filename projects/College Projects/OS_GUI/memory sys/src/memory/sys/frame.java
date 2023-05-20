/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory.sys;

/**
 *
 * @author noureldin
 */
public class frame {
    private int base,access,seg_size;
    public frame(int a,int b,int c){
        base = a;
        access = b;
        seg_size = c;
    }

    public int get_base(){
        return base;
    }
    public int get_access(){
        return access;
    }

    boolean contains(int b) {
        return base <= b && b < base + seg_size;
    }
}
