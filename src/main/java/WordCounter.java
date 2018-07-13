import org.junit.Test;

import java.io.*;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Takes in input file of text, keeps track of all the unique words
 */
public class WordCounter {

    HashMap<String, Integer> catalogue = new HashMap<String, Integer>();

    public WordCounter(File file) throws IOException {
        BufferedReader br =  new BufferedReader(new FileReader(file));
        for(String line; (line = br.readLine()) != null; ) {
            if (!line.isEmpty()) {
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
                for( String word : words) {
                    catalogue.put(word, getWordOccurance(word) + 1);
                }
            }
        }
    }

    public int getWordOccurance(String word) {
        if (catalogue.containsKey(word)) {
            return catalogue.get(word);
        }
        else {
            return 0;
        }
    }

    public int size() {
        return catalogue.size();
    }


    /** TESTS **/
    @Test
    public void GoodInput() {
        try {
            WordCounter wc = new WordCounter(new File("E:\\Code\\CodingQuestions\\src\\test\\resources\\words.txt"));
            assertEquals(85, wc.getWordOccurance("test"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void EmptyFile() {
        try {
            WordCounter wc = new WordCounter(new File("E:\\Code\\CodingQuestions\\src\\test\\resources\\nowords.txt"));
            assertEquals(0, wc.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
