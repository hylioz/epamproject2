package textcomposite;

import utils.TextParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Text implements Vocabulary {

    private static final Logger LOGGER = Logger.getLogger(Text.class);

    private ArrayList<String> texts = new ArrayList<>();
    private Paragraph paragraph;

    public Text(String textFromFile) {
        texts.add(TextParser.correctText(textFromFile));
        ArrayList<String> paragraphs = TextParser.parseToParagraph(texts);
        if (paragraphs == null) {
            LOGGER.info("Paragraphs list is empty {Text constructor}");
        } else {
            paragraph = new Paragraph(paragraphs);
        }
    }

    @Override
    public ArrayList<String> getValue(Vocabulary v) {
        if (v instanceof Text)
            return texts;
        return paragraph.getValue(v);
    }

    @Override
    public void print() {
        System.out.println(texts);
    }

}
