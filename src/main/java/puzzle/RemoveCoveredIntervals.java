package puzzle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a list of intervals, remove all intervals that are covered by another interval in the list.
 *
 * Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
 *
 * After doing so, return the number of remaining intervals.
 */
public class RemoveCoveredIntervals {

    public int removeCoveredIntervals(int[][] intervals) {
        int uniqueCount = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            for(int j = 0; j < intervals.length; j++) {
                // skip checking the same interval
                if (i == j) {
                    continue;
                }

                // see if intervals at i are covered. if every yes, then flag for removal
                if ((intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) ||
                    (intervals[i][0] > intervals[j][0] && intervals[i][1] <= intervals[j][1])) {
                    uniqueCount--;
                    break;
                }
            }
        }
        return uniqueCount;
    }

    @Test
    public void unitTest1() {
        int actualResult = removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}});
        Assert.assertEquals(2, actualResult);
    }

    @Test
    public void unitTest2() {
        int actualResult = removeCoveredIntervals(new int[][]{{1,4},{2,3}});
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void unitTest3() {
        int actualResult = removeCoveredIntervals(new int[][]{{0,10},{5,12}});
        Assert.assertEquals(2, actualResult);
    }

    @Test
    public void unitTest4() {
        int actualResult = removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}});
        Assert.assertEquals(2, actualResult);
    }

    @Test
    public void unitTest5() {
        int actualResult = removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}});
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void unitTest6() {
        int actualResult = removeCoveredIntervals(new int[][]{{34335,39239},{15875,91969},{29673,66453},{53548,69161},{40618,93111}});
        Assert.assertEquals(2, actualResult);
    }
}
