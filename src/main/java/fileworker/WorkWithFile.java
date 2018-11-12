package fileworker;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkWithFile {
    private static final Logger LOGGER = Logger.getLogger(WorkWithFile.class);

    public static String ReadFromFile(String path) {
        String textFromFile = null;
        try {
            textFromFile = new String(Files.readAllBytes(Paths.get(path)));
            LOGGER.info("File read successfully");

        } catch (IOException e) {
            LOGGER.error("File reading error",e);
        }
        LOGGER.info("TEXT:\n" + textFromFile);
        return textFromFile;
    }
}

