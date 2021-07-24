/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termnology;

import scanner.keyWord;

/**
 *
 * @author DELL
 */
public class terminal extends Symbol {

   keyWord term_key;

    public terminal(keyWord term_key) {
        this.term_key = term_key;
    }

    @Override
    public String toString() {
        return term_key.toString();
    }
   


}
