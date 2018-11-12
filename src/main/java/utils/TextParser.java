package utils;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static final Logger LOGGER = Logger.getLogger(TextParser.class);

    private static final Pattern SENTENCE_PATTERN = Pattern.compile("[A-Z].+?[.!?]");

    public static String correctText(String textFromFile) {
        return textFromFile.replaceAll("[\n\r]+", "\n\r")
                .replaceAll("\\b[ ]+\\b", " ")
                .replaceAll("\\.[ ]+\\b", ". ")
                .replaceAll("\\b[ ]+\\.", ".");
    }

    public static ArrayList<String> correctWord(ArrayList<String> words) {
        ArrayList<String> correctedWord = new ArrayList<>();
        for (String word : words) {
            correctedWord.add(word.replaceAll("[.,?!\";:]", "").toLowerCase());
        }
        return correctedWord;
    }

    public static ArrayList<String> parseToParagraph(ArrayList<String> texts) {
        if (texts.isEmpty()) {
            LOGGER.info("Texts are empty {parseToParagraph}");
            return null;
        }
        ArrayList<String> paragraphs = new ArrayList<>();
        for (String text : texts) {
            String[] splitText = text.split("\n+\r+");
            LOGGER.trace("First paragraph {Text constructor} " + splitText[0]);
            Collections.addAll(paragraphs, splitText);
        }
        return paragraphs;
    }

    public static ArrayList<String> parseToSentence(ArrayList<String> paragraphs) {
        if (paragraphs.isEmpty()) {
            LOGGER.info("Paragraphs are empty {parseToSentence}");
            return null;
        }
        ArrayList<String> sentences = new ArrayList<>();
        for (String paragraph : paragraphs) {
            Matcher matcher = SENTENCE_PATTERN.matcher(paragraph);
            while (matcher.find()) {
                LOGGER.trace("Find sentence! {parseToSentence}");
                sentences.add(matcher.group());
            }
        }
        return sentences;
    }

    public static ArrayList<String> parseToWord(ArrayList<String> sentences) {
        if (sentences.isEmpty()) {
            LOGGER.info("Sentences are empty {parseToWord}");
            return null;
        }
        ArrayList<String> words = new ArrayList<>();
        for (String sentence : sentences) {
            String[] splitSentence = sentence.split("\\s+");
            Collections.addAll(words, splitSentence);
        }
        return words;
    }

    public static ArrayList<String> parseToSymbol(ArrayList<String> words) {
        if (words.isEmpty()) {
            LOGGER.info("Words are empty {parseToSymbol}");
            return null;
        }
        ArrayList<String> symbols = new ArrayList<>();
        for (String word : words) {
            String[] splitWord = word.split("");
            Collections.addAll(symbols, splitWord);
        }
        return symbols;
    }
}
