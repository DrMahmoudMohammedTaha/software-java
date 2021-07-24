/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scanner;

/**
 *
 * @author DELL
 */
public abstract class keyWord {
    public final String codeValue;
    public final String scannerValue;
    
    

    public keyWord(String codeValue, String scannerValue) {
        this.codeValue = codeValue;
        this.scannerValue = scannerValue;
    }

    @Override
    public String toString() {
        return scannerValue;
    }
    
    
    public void action(String temp){};
    public String show(){ return " ";};
    
}
