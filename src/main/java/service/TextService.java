package service;

import fileworker.WorkWithFile;
import org.apache.log4j.Logger;
import textcomposite.Text;

import java.util.ArrayList;
import java.util.Collections;

public class TextService {
    private static final Logger LOGGER = Logger.getLogger(TextService.class);

    public Text initText(String path) {
        String textFromFile = WorkWithFile.ReadFromFile(path);
        return new Text(textFromFile);
    }

    public ArrayList<String> printSortedWords(ArrayList<String> words) {
        Collections.sort(words);
        ArrayList<String> sortedWords = new ArrayList<>();
        char currentLetter = 'a';
        for (String word : words) {
            if (!word.isEmpty()) {
                if (word.charAt(0) == currentLetter) {
                    System.out.print(word + " ");
                    sortedWords.add(word);
                } else {
                    sortedWords.add("\n");
                    sortedWords.add(word);
                    System.out.println();
                    System.out.print(word + " ");
                    currentLetter = word.charAt(0);
                }
            } else {
                LOGGER.info("Detected empty word {printSortedWords}");
            }

        }
        return sortedWords;
    }
}
