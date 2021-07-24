/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsing;

import java.util.ArrayList;
import termnology.Symbol;

/**
 *
 * @author DELL
 */
public class Expression {

    public ArrayList<Production> AdditiveElements = new ArrayList<>();

    public Expression(Production... prodData) {
        for (int i = 0; i < prodData.length; i++) {
            AdditiveElements.add(prodData[i]);
        }
    }
 
 public Expression(Symbol... prodData) {
        for (int i = 0; i < prodData.length; i++) {
          Production p =   new Production();
          p.symbols.add(prodData[i]);
          AdditiveElements.add(p);
        }
    }
}
