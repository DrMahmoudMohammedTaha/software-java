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
public class RAM {
    private Integer [] table;
    public RAM(int MAX){
        table = new Integer[MAX];
    }
    public void write(int p,int v){
        table[p] = v;
    }

    Integer read(int i) {
        return table[i];
    }

    boolean taken_frame(frame f) {
        return table[f.get_base()] != null;
    }

    void clear(frame f) {
        table[f.get_base()] = null;
    }
}
