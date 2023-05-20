/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memory.sys;

import java.util.LinkedList;
import sun.security.util.PropertyExpander;

/**
 *
 * @author noureldin
 */

public class Page {
    private LinkedList<frame> page;
    public Page(){
        page = new LinkedList<frame>();
    }

    frame get_frame(int b) {
        for(frame f : page){
            if (f.contains(b)) return f;
        }
        return null;
    }

    void insert(frame map) {
        page.add(map);
    }

    void free() {
        for (frame f : page){
            virtual_memory.mem.clear(f);
        }
    }
    public LinkedList<frame> get_all(){
        return page;
    }
}
