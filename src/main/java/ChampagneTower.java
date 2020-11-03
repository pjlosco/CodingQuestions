import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;


public class ChampagneTower {

    ArrayList<double[]> rows = new ArrayList<>();


    public double champagneTower(int poured, int query_row, int query_glass) {
        int filledGlasses = 0;
        while (filledGlasses < poured) {
            int currentRow = rows.size()+1;
            if (poured >= currentRow) {
                double[] filledAmountPerGlass = new double[currentRow];
                Arrays.fill(filledAmountPerGlass, 1);
                rows.add(filledAmountPerGlass);
                filledGlasses = filledGlasses + currentRow;
            }
        }
        try {
            return rows.get(query_row - 1)[query_glass - 1];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }


    @Test
    public void unitTest1() {
        double actualResult = champagneTower(1, 1, 1);
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void unitTest2() {
        double actualResult = champagneTower(2, 1, 1);
        double expectedResult = 0.5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void unitTest3() {
        double actualResult = champagneTower(100000009, 33, 17);
        double expectedResult = 1.0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void unitTest() {
        double actualResult = champagneTower(1, 2, 2);
        double expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }
}
