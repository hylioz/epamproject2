package textcomposite;

import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Symbol implements Vocabulary {
    private static final Logger LOGGER = Logger.getLogger(Symbol.class);

    private ArrayList<String> symbols;

    public Symbol() {
    }

    public Symbol(ArrayList<String> symbols) {
        this.symbols = symbols;
    }

    @Override
    public ArrayList<String> getValue(Vocabulary v) {
        if (v instanceof Symbol) {
            return symbols;
        }
        return null;
    }

    public void print() {
        System.out.println(symbols);
    }

}
