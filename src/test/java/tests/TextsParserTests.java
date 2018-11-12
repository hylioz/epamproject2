package tests;

import fileworker.WorkWithFile;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.TextService;
import utils.TextParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TextsParserTests {
    private final static Logger LOGGER = Logger.getLogger(TextsParserTests.class);

//    public Text getText(String path) {
//        TextService textService = new TextService();
//        return textService.initText(path);
//    }

    @Test
    public void correctTextTest() {
        String expectedText = TextParser.correctText(WorkWithFile.ReadFromFile("test_correct.txt"));
        String actualText = "Bsf gkgo gfjigfs gfgf. Afd kfg hsbd gvsd bgfs.\n\rDsd gfij vbm srdf ndt. Sfndj fj fngj fly jdb.";
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void correctWordTest() {
        ArrayList<String> expectedWord = new ArrayList<>(Arrays.asList("word1", "word2", "word3"));
        ArrayList<String> actualWord = TextParser.correctWord(new ArrayList<>(Arrays.asList("wor,d1", ".word2", "word3?")));
        Assert.assertEquals(actualWord, expectedWord);
    }

    @Test
    public void parseToParagraphTest() {
        ArrayList<String> expectedParagraph = new ArrayList<>(Arrays.asList("paragraph1", "paragraph2", "paragraph3"));
        ArrayList<String> actualParagraph = TextParser.parseToParagraph(new ArrayList<>(Collections.singletonList("paragraph1\n\rparagraph2\n\rparagraph3\n\r")));
        Assert.assertEquals(actualParagraph, expectedParagraph);
    }

    @Test
    public void parseToSentenceTest() {
        ArrayList<String> expectedSentence = new ArrayList<>(Arrays.asList("Fgh hfgh sentence1.", "Ter uty sentence2.", "Cvb mhg sentence3."));
        ArrayList<String> actualSentence = TextParser.parseToSentence(new ArrayList<>(Collections.singletonList("Fgh hfgh sentence1. Ter uty sentence2. Cvb mhg sentence3.")));
        Assert.assertEquals(actualSentence, expectedSentence);
    }

    @Test
    public void parseToWordTest() {
        ArrayList<String> expectedWord = new ArrayList<>(Arrays.asList("Word1", "word2,", "word3"));
        ArrayList<String> actualWord = TextParser.parseToWord(new ArrayList<>(Collections.singletonList("Word1 word2, word3")));
        Assert.assertEquals(actualWord, expectedWord);
    }

    @Test
    public void parseToSymbolTest() {
        ArrayList<String> expectedSymbol = new ArrayList<>(Arrays.asList("w", "o", "r", "d"));
        ArrayList<String> actualSymbol = TextParser.parseToSymbol(new ArrayList<>(Collections.singletonList("word")));
        Assert.assertEquals(actualSymbol, expectedSymbol);
    }

    @Test
    public void printSortedWordsTest() {
        TextService textService = new TextService();
        ArrayList<String> expectedSortWords = new ArrayList<>(Arrays.asList("alcohol", "all", "\n", "deep", "\n", "hello", "hero", "hi", "home", "\n", "year", "you"));
        ArrayList<String> actualSortWords = textService.printSortedWords(new ArrayList<>(Arrays.asList("hello", "year", "deep", "home", "alcohol", "hero", "all", "hi", "you")));
        Assert.assertEquals(actualSortWords, expectedSortWords);
    }
}