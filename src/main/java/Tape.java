import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Tape {

    /*********
    1. We have a huge number line from -infinity to infinity.
     Given a red tape and a set of blue tapes. Tape is represented by interval.
     We paste red tape on the number line first and paste blue tapes onto the line later.
     If blue tapes have overlap with red tape, the overlapping part will be covered by blue tapes.
     You need to return a boolean to indicate whether red tape is visible .

    Ex:
        Blue    ~~~~~~~~~~~~~~~~~~~     ~~~~~~~~~~~~~                     [1,3][4,6]
        Red     =====================================                     [1,6]
                |-----|-----|-----|-----|-----|-----|-----|-----|-----|
                0     1     2     3     4     5     6     7     8     9
    ********/
    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    ArrayList<Interval> getBlueSortedAndFiltered(Interval boundaries, Interval[] blues) {
        ArrayList<Interval> validBlues = new ArrayList<>();
        for (Interval blue : blues) {
            if (blue.end < boundaries.start) {
                continue;
            } else if (blue.start > boundaries.end) {
                continue;
            } else if (blue.start == boundaries.start && blue.end == boundaries.end) {
                continue;
            } else {
                // add to list
                for (int index = 0; index <= validBlues.size(); index++) {
                    if (validBlues.isEmpty()) {
                        validBlues.add(blue);
                        break;
                    } else {
                        Interval comparingBlue = validBlues.get(index);
                        if (blue.start < comparingBlue.start) {
                            validBlues.add(index, blue);
                            break;
                        } else if (blue.start == comparingBlue.start) {
                            // check end values
                            if (blue.end < comparingBlue.end) {
                                validBlues.add(index, blue);
                                break;
                            } else {
                                if (validBlues.size() == index+1) {
                                    validBlues.add(blue);
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            // newBlue.start > comparingBlue.start
                            if (validBlues.size() == index+1) {
                                validBlues.add(blue);
                                break;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return validBlues;
    }

    boolean isRedVisible(Interval red, Interval[] blue) {
        // sort the blue array based on start values first
        ArrayList<Interval> blueSorted = getBlueSortedAndFiltered(red, blue);

        // check for empty valid list
        if (blueSorted.size() == 0) {
            return true;
        }

        // check for complete coverage
        if (blueSorted.size() == 1) {
            if (blueSorted.get(0).start > red.start || blueSorted.get(0).end < red.end) {
                return false;
            }
        }

        // check edges for coverage
        if (blueSorted.get(0).start > red.start || blueSorted.get(blueSorted.size()-1).end < red.end ) {
            return true;
        }

        // assume array now in focus has values needed to look for gaps
        for (int index = 0; index+1 < blueSorted.size(); index++) {
            Interval comparingStartInterval = blue[index];
            Interval comparingNextInterval = blue[index+1];
            if (comparingStartInterval.end < comparingNextInterval.start) {
                return true;
            }
        }

        return false;
    }


    @Test
    public void unitTest1() {
        Interval red = new Interval(1,6);
        Interval b1 = new Interval(1,3);
        Interval b2 = new Interval(3,6);
        Interval[] blue = new Interval[]{b1, b2};
        Assert.assertFalse(isRedVisible(red, blue));
    }

    @Test
    public void unitTest2() {
        Interval red = new Interval(1,6);
        Interval b1 = new Interval(1,3);
        Interval b2 = new Interval(3,6);
        Interval b3 = new Interval(3,6);
        Interval b4 = new Interval(7,9);
        Interval[] blue = new Interval[]{b1, b2, b3, b4};
        Assert.assertFalse(isRedVisible(red, blue));
    }

    @Test
    public void unitTest3() {
        Interval red = new Interval(1,6);
        Interval b1 = new Interval(1,3);
        Interval b2 = new Interval(4,6);
        Interval b3 = new Interval(7,9);
        Interval[] blue = new Interval[]{b1, b2, b3};
        Assert.assertTrue(isRedVisible(red, blue));
    }
}
