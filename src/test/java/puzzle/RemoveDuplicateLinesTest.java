package puzzle;

import org.junit.Test;
import puzzle.RemoveDuplicateLinesFromFile;

import java.io.File;


public class RemoveDuplicateLinesTest {

    @Test
    public void NoRepeatLines() {
        new RemoveDuplicateLinesFromFile(new File("./NoRepeats.txt"));
    }

    @Test
    public void AllLinesRepeatOnce() {

    }

    @Test
    public void OneRepeatedLine() {

    }

    @Test
    public void RepeatedLineWithinNoRepeats(){

    }
}
