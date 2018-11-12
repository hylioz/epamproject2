package textcomposite;

import org.apache.log4j.Logger;
import utils.TextParser;

import java.util.ArrayList;

public class Word implements Vocabulary {
    private static final Logger LOGGER = Logger.getLogger(Word.class);
    private ArrayList<String> words;
    private Symbol symbol;

    public Word() {
    }

    public Word(ArrayList<String> words) {
        ArrayList<String> symbols = TextParser.parseToSymbol(words);
        this.words = TextParser.correctWord(words);
        if (symbols == null) {
            LOGGER.info("Symbols list is empty {Word constructor}");
        } else {
            symbol = new Symbol(symbols);
        }
    }

    @Override
    public ArrayList<String> getValue(Vocabulary v) {
        if (v instanceof Word) {
            return words;
        }
        return symbol.getValue(v);
    }

    @Override
    public void print() {
        System.out.println(words);
    }

}
