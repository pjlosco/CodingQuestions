import junit.framework.Assert;
import org.junit.Test;

public class MergeIntArrayTests {

    public void printSet(int[] set, String setName) {
        System.out.print(setName + ": {");
        for (int location = 0; location < set.length; location++) {
            System.out.print(set[location]);
            if (location<set.length-1) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    @Test
    public void checkIterativeSort() {
        int[] set = {1,3,5,6,2,4,0,-9};
        printSet(set, "Starting set");
        int[] expectedSet = {-9,0, 1, 2, 3, 4, 5, 6};
        printSet(expectedSet, "Expected");

        set = new MergeIntArray().iterativeSort(set);
        for (int location = 0; location < set.length; location++) {
            Assert.assertEquals(expectedSet[location], set[location]);
        }
        printSet(set, "Actual");
    }

    @Test
    public void Merge2GoodIntArrays() {
        int[] set1 = {1,3,5,9,7};
        int[] set2 = {8,4,6,2};
        printSet(set1, "Starting set1");
        printSet(set2, "Starting set2");
        int[] expectedSet = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printSet(expectedSet, "Expected");

        int[] mergedSet = new MergeIntArray(set1, set2).iterativeMerge();
        printSet(mergedSet, "Actual");
        for (int location = 0; location < mergedSet.length; location++) {
            Assert.assertEquals(expectedSet[location], mergedSet[location]);
        }
    }

    @Test
    public void MergeSortIntArray() {
        int[] set = {6,-9,4,0,5,1,3,2,7};
        printSet(set, "Starting set");
        int[] expectedSet = {-9,0, 1, 2, 3, 4, 5, 6, 7};
        printSet(expectedSet, "Expected");

        set = new MergeIntArray().mergeSort(set);
        for (int location = 0; location < set.length; location++) {
            Assert.assertEquals(expectedSet[location], set[location]);
        }
        printSet(set, "Actual");
    }

}
