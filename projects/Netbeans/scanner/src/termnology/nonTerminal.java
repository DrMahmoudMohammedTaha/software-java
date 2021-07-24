/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termnology;

import parsing.Expression;
import parsing.Production;

/**
 *
 * @author DELL
 */
public class nonTerminal extends Symbol {

    Expression expression;
    public String name = "";
    public String states[];

    public nonTerminal(Expression expression) {
        this.expression = expression;
    }

    @Override
    public Production getProduction(String token) {
    
        for (int i = 0; i < states.length; i++) {
            if (states[i].contains(token)) {
                int index = Integer.parseInt(states[i].split(" ")[1]);
                if (index == -1) {
                   return new Production(null);
                } else {
                    if(expression.AdditiveElements.get(index).repeated)
                    return new Production( this , true  , expression.AdditiveElements.get(index) );
                    else 
                    return expression.AdditiveElements.get(index);
                }
            }
        }
        return null;
    }

    public nonTerminal(String name, Expression expression) {
        this.name = name;
        this.expression = expression;
    }

    public nonTerminal(String name, Expression expression, String[] states) {
        this.name = name;
        this.expression = expression;
        this.states = states;
    }

    public nonTerminal(Expression expression, String[] states) {
        this.expression = expression;
        this.states = states;
    }

    public String getContent() {
        String temp = "";
        for (int i = 0; i < expression.AdditiveElements.size(); i++) {
            if (expression.AdditiveElements.get(i).repeated) {
                temp += " [ ";
            }
            for (int j = 0; j < expression.AdditiveElements.get(i).symbols.size(); j++) {
                temp += expression.AdditiveElements.get(i).symbols.get(j) + " ";
                //    System.out.println(temp);
            }
            if (expression.AdditiveElements.get(i).repeated) {
                temp += " ] * ";
            }

            if (i != expression.AdditiveElements.size() - 1) {
                temp += " | ";
            }
        }

        return temp;
    }

    public String getSentence() {
        return name + " --> " + getContent();

    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public void setExpression(Expression expression, String[] temp) {
         this.expression = expression;
         states = temp;
    }

    @Override
    public String toString() {
        if (!name.equals("")) {
            return " " + name + " ";
        }
        String temp = "";
        for (int i = 0; i < expression.AdditiveElements.size(); i++) {
            if (expression.AdditiveElements.get(i).repeated) {
                temp += " [ ";
            }
            for (int j = 0; j < expression.AdditiveElements.get(i).symbols.size(); j++) {
                temp += expression.AdditiveElements.get(i).symbols.get(j) + " ";
            }
            if (expression.AdditiveElements.get(i).repeated) {
                temp += " ] * ";
            }

            if (i != expression.AdditiveElements.size() - 1) {
                temp += " | ";
            }
        }

        return temp;
    }

    
}
