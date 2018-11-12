package textcomposite;

import utils.TextParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Paragraph implements Vocabulary {
    private static final Logger LOGGER = Logger.getLogger(Paragraph.class);

    private ArrayList<String> paragraphs;
    private Sentence sentence;

    public Paragraph() {
    }

    public Paragraph(ArrayList<String> paragraphs) {
        this.paragraphs = paragraphs;
        ArrayList<String> sentences = TextParser.parseToSentence(paragraphs);
        if (sentences == null) {
            LOGGER.info("Sentences list is empty {Paragraph constructor}");
        } else {
            sentence = new Sentence(sentences);
        }
    }

    @Override
    public ArrayList<String> getValue(Vocabulary v) {
        if (v instanceof Paragraph) {
            return paragraphs;
        }
        return sentence.getValue(v);
    }

    @Override
    public void print() {
        System.out.println(paragraphs);
    }

}
