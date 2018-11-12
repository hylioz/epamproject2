package tests;

import fileworker.WorkWithFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadFromFileTest {
    @Test
    public void readFileTest() {
        String str = WorkWithFile.ReadFromFile("test_read.txt");
        Assert.assertEquals("itsOk?", str);
    }
}
