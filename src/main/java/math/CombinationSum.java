package math;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique
 * combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * <p>
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations
 * for the given input.
 * <p>
 * Example 1:
 * <p>
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {

    private List<List<Integer>> validCombinationList = new ArrayList<>();


    List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> candidatesAsList = intArrayToList(candidates);
        candidatesAsList.sort(Collections.reverseOrder());
        while (candidatesAsList.size() > 0) {
            List<Integer> remainingCandidates = new ArrayList<>(candidatesAsList);
            validCombinationSearch(remainingCandidates, target, new ArrayList<>());
            candidatesAsList.remove(0);
        }
        return this.validCombinationList;
    }

    /**
     * @param candidates   should be pre sorted
     * @param target       remaining value to sum
     * @param currentCombo
     * @return
     */
    private void validCombinationSearch(List<Integer> candidates, int target, List<Integer> currentCombo) {
        if (candidates.isEmpty()) {
            return;
        }

        int lastCandidate = candidates.get(0);
        if (lastCandidate > target) {
            // current combo is invalid, remove from list. call again. add to current combo
            candidates.remove(0);
            validCombinationSearch(candidates, target, currentCombo);
        } else if (lastCandidate == target) {
            // current combo is finished
            currentCombo.add(lastCandidate);
            Collections.reverse(currentCombo);
            if (!validCombinationList.contains(currentCombo)) {
                validCombinationList.add(0, currentCombo);
            }
        } else {
            // current combo is still good. reduce and repeat. add together
            currentCombo.add(lastCandidate);
            target = target - lastCandidate;
            List<Integer> candidatesCopy = new ArrayList<>(candidates);
            while (candidatesCopy.size() > 0) {
                validCombinationSearch(new ArrayList<>(candidatesCopy), target, new ArrayList<>(currentCombo));
                candidatesCopy.remove(0);
            }
        }
    }

    public List<Integer> intArrayToList(int[] input) {
        return Arrays.stream(input).boxed().collect(Collectors.toList());
    }


    public List<List<Integer>> solution(int[] candidates, int target) {
        validCombinationList = new ArrayList<>();
        ans(0, new ArrayList<Integer>(), candidates, target);
        return validCombinationList;
    }

    void ans(int start, ArrayList<Integer> currentCombo, int[] candidates, int target) {
        if (target == 0) {
            validCombinationList.add(new ArrayList(currentCombo));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int index = start; index < candidates.length; index++) {
            int candidate = candidates[index];
            if (candidate <= target) {
                currentCombo.add(candidate);
                ans(index, currentCombo, candidates, target - candidate);
                currentCombo.remove(currentCombo.size() - 1);
            }
        }
    }

    @Test
    public void unitTest1() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(intArrayToList(new int[]{2, 2, 3}));
        expectedResults.add(intArrayToList(new int[]{7}));
        List<List<Integer>> actualResults = combinationSum(new int[]{2, 3, 6, 7}, 7);
        Assert.assertEquals(expectedResults, actualResults);
    }

    @Test
    public void unitTest2() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(intArrayToList(new int[]{2, 2, 2, 2}));
        expectedResults.add(intArrayToList(new int[]{2, 3, 3}));
        expectedResults.add(intArrayToList(new int[]{3, 5}));
        Assert.assertEquals(expectedResults, combinationSum(new int[]{2, 3, 5}, 8));
    }

    @Test
    public void unitTest3() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        Assert.assertEquals(expectedResults, combinationSum(new int[]{2}, 1));
    }

    @Test
    public void unitTest4() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(intArrayToList(new int[]{1}));
        Assert.assertEquals(expectedResults, combinationSum(new int[]{1}, 1));
    }

    @Test
    public void unitTest5() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(intArrayToList(new int[]{1, 1}));
        Assert.assertEquals(expectedResults, combinationSum(new int[]{1}, 2));
    }

    @Test
    public void unitTest6() {
        List<List<Integer>> expectedResults = new ArrayList<>();
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 1, 1, 1, 1, 2}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 1, 1, 1, 3}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 1, 1, 2, 2}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 1, 2, 3}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 1, 5}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 2, 2, 2}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 3, 3}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 1, 6}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 2, 2, 3}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 2, 5}));
        expectedResults.add(intArrayToList(new int[]{1, 1, 7}));
        expectedResults.add(intArrayToList(new int[]{1, 2, 2, 2, 2}));
        expectedResults.add(intArrayToList(new int[]{1, 2, 3, 3}));
        expectedResults.add(intArrayToList(new int[]{1, 2, 6}));
        expectedResults.add(intArrayToList(new int[]{1, 3, 5}));
        expectedResults.add(intArrayToList(new int[]{2, 2, 2, 3}));
        expectedResults.add(intArrayToList(new int[]{2, 2, 5}));
        expectedResults.add(intArrayToList(new int[]{2, 7}));
        expectedResults.add(intArrayToList(new int[]{3, 3, 3}));
        expectedResults.add(intArrayToList(new int[]{3, 6}));
        Assert.assertEquals(expectedResults, solution(new int[]{2, 7, 6, 3, 5, 1}, 9));
    }
}
