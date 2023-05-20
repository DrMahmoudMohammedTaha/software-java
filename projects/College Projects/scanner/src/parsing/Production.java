package parsing;

import java.util.ArrayList;
import termnology.Symbol;
import termnology.nonTerminal;

public class Production {

    public ArrayList<Symbol> symbols = new ArrayList<>();
    public Boolean repeated = false;

    public Production(Symbol... symbolData) {
        if (symbolData != null) {
            for (int i = 0; i < symbolData.length; i++) {
                symbols.add(symbolData[i]);
            }
        }
    }

    public Production(nonTerminal v, boolean x, Production... ProductionData) {

        for (int i = 0; i < ProductionData.length; i++) {
            for (int j = 0; j < ProductionData[i].symbols.size(); j++) {
                symbols.add(ProductionData[i].symbols.get(j));
            }
        }
        symbols.add(v);

    }

    public Production(boolean state, Symbol... symbolData) {
        repeated = state;
        for (int i = 0; i < symbolData.length; i++) {
            symbols.add(symbolData[i]);
        }
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < symbols.size(); i++) {
            Symbol tmp_smp = symbols.get(i);
            if (tmp_smp instanceof nonTerminal) {
                temp += " " + ((nonTerminal) tmp_smp).name;

            } else {
                temp += " " + tmp_smp.toString();
            }

        }
        return temp;
    }

}
