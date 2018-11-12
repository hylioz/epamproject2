package textcomposite;

import utils.TextParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Sentence implements Vocabulary {
    private static final Logger LOGGER = Logger.getLogger(Sentence.class);
    private ArrayList<String> sentences;
    private Word word;

    public Sentence() {
    }

    public Sentence(ArrayList<String> sentences) {
        this.sentences = sentences;
        ArrayList<String> words = TextParser.parseToWord(sentences);
        if (words == null) {
            LOGGER.info("Words list is empty {Sentence constructor}");
        } else {
            word = new Word(words);
        }
    }

    @Override
    public ArrayList<String> getValue(Vocabulary v) {
        if (v instanceof Sentence) {
            return sentences;
        }
        return word.getValue(v);
    }

    @Override
    public void print() {
        System.out.println(sentences);
    }
}
