package tests;

import org.testng.annotations.Test;
import service.TextService;
import textcomposite.*;

import java.util.ArrayList;

public class MainTest {
    @Test
    public void taskRun() {
        TextService textService = new TextService();
        Text text = textService.initText("text4.txt");

        Paragraph paragraph = new Paragraph();
        Sentence sentence = new Sentence();
        Word word = new Word();
        Symbol symbol = new Symbol();

        ArrayList<String> paragraphs = text.getValue(paragraph);
        ArrayList<String> sentences = text.getValue(sentence);
        ArrayList<String> words = text.getValue(word);
        ArrayList<String> symbols = text.getValue(symbol);

        System.out.println("__________________________");
        for (String str : paragraphs) {
            System.out.println("PARAGRAPH: " + str);
        }
        System.out.println("__________________________");
        for (String str : sentences) {
            System.out.println("SENTENCE: " + str);
        }
        System.out.println("__________________________");
        for (String str : words) {
            System.out.println("WORD: " + str);
        }
        System.out.println("SORTED WORD: ");
        textService.printSortedWords(words);
        System.out.println();
        System.out.println("__________________________");
        for (String str : symbols) {
            System.out.println("SYMBOL: " + str);
        }
    }

}
