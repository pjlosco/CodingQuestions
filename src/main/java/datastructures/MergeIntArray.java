package datastructures;

/**
 * Sort arrays and then merge them in order
 */
public class MergeIntArray {

    int[] set1;
    int[] set2;

    public MergeIntArray() {

    }

    public MergeIntArray(int[] set1, int[] set2) {
        this.set1 = set1;
        this.set2 = set2;
    }

    public int[] iterativeSort(int[] set) {
        int swapSpot = 0;
        while (set != null && swapSpot < set.length) {
            int minValue = set[swapSpot];
            int minLocation = swapSpot;

            // find minimum value in remaining part of set
            for (int index = swapSpot + 1; index < set.length; index++) {
                if (minValue > set[index]) {
                    minValue = set[index];
                    minLocation = index;
                }
            }

            // swap the values if possible
            if (minValue < set[swapSpot]) {
                int temp = set[swapSpot];
                set[swapSpot] = minValue;
                set[minLocation] = temp;
            }
            swapSpot++;
        }
        return set;
    }

    public int[] iterativeMerge() {
        int[] mergedArray = null;
        if (set1 != null && set2 != null) {
            set1 = iterativeSort(set1);
            set2 = iterativeSort(set2);
            mergedArray = new int[set1.length+set2.length];
            int set1Index = 0;
            int set2Index = 0;
            int mergedIndex = 0;
            while (mergedIndex < mergedArray.length) {
                // check index for out of bounds before comparing
                if (set1Index >= set1.length) {
                    mergedArray[mergedIndex] = set2[set2Index];
                    set2Index++;
                } else if (set2Index >= set2.length){
                    mergedArray[mergedIndex] = set1[set1Index];
                    set1Index++;
                } else if (set1[set1Index] < set2[set2Index]) {
                    mergedArray[mergedIndex] = set1[set1Index];
                    set1Index++;
                } else {
                    mergedArray[mergedIndex] = set2[set2Index];
                    set2Index++;
                }
                mergedIndex++;
            }
        }
        return mergedArray;
    }

    public int[] mergeSort(int[] set) {
        // split set
        int[] set1;
        if (set.length % 2 == 0) {
            set1 = new int[set.length/2];
        } else {
            set1 = new int[set.length/2 + 1];
        }
        int[] set2 = new int[set.length/2];
        for(int index = 0; index < set.length; index++) {
            if (index < set1.length) {
                set1[index] = set[index];
            } else {
                set2[index-set1.length] = set[index];
            }
        }

        // recursive call
        if (set1.length > 1) {
            set1 = mergeSort(set1);
        }
        if (set2.length > 1) {
            set2 = mergeSort(set2);
        }

        // merge 2 sets back together
        int set1index = 0;
        int set2index = 0;
        for(int index = 0; index < set.length; index++) {
            // compare remaining values
            if (set1index < set1.length && set2index < set2.length) {
                if (set1[set1index] < set2[set2index]) {
                    set[index] = set1[set1index];
                    set1index++;
                } else {
                    set[index] = set2[set2index];
                    set2index++;
                }
            }
            // set1 has no more remaining values
            else if (set1index >= set1.length) {
                set[index] = set2[set2index];
                set2index++;
            }
            // set2 has no more remaining values
            else {
                set[index] = set1[set1index];
                set1index++;
            }
        }

        return set;
    }

}
