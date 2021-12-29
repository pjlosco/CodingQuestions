package puzzle;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CellsTest {

    @Test
    public void inputTest() {
        Cells cells = new Cells();
        int[] states = {1, 0, 0, 0, 0, 1, 0, 0};
        int days = 1;
        ArrayList<Integer> newList = cells.convertArrayToList(new int[]{0, 1, 0, 0, 1, 0, 1, 0});
        Assert.assertEquals(newList, cells.cellCompete(states, days));
    }

    @Test
    public void input2Test() {
        Cells cells = new Cells();
        int[] states = {1, 1, 1, 0, 1, 1, 1, 1};
        int days = 2;
        ArrayList<Integer> newList = cells.convertArrayToList(new int[]{0, 0, 0, 0, 0, 1, 1, 0});
        Assert.assertEquals(newList, cells.cellCompete(states, days));
    }
}
