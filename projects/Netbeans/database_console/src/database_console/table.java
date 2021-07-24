/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database_console;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class table {

    
    String name;
    ArrayList<String> cols = new ArrayList();

    public table(String name , String...col) {
        this.name = name;
        for (int i = 0; i < col.length; i++) {
            cols.add(col[i]);
        }
    }

    public  String [] getCols()
    {
    String [] temp = new String [cols.size()];
        for (int i = 0; i < cols.size(); i++) {
            temp[i] = cols.get(i);
        }
    return temp;
    }

}
