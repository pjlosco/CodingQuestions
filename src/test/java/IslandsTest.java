import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IslandsTest {

    @Test
    public void inputTest() {
        int[][] mat =
                {
                        {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
                };
        Islands islands = new Islands();
        assertEquals(6, islands.NumberOfIslands(mat));
    }

    @Test
    public void input2Test() {
        int[][] mat =
                {
                        {0, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
                };
        Islands islands = new Islands();
        assertEquals(6, islands.NumberOfIslands(mat));
    }

    @Test
    public void input3Test() {
        int[][] mat =
                {
                        {0, 1, 0, 0, 0},
                        {1, 0, 1, 0, 1}
                };
        Islands islands = new Islands();
        assertEquals(4, islands.NumberOfIslands(mat));
    }
}
