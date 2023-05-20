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

public class Main {
    public static void main(String[] args) throws Exception{
        virtual_memory.mem = new RAM(virtual_memory.MAX);
        virtual_memory vm1,vm2;
        vm1 = new virtual_memory();
        vm2 = new virtual_memory();
        vm1.add_adress(0, 0);
       // vm2.add_adress(0, 0);
    }
}
