package puzzle;

import java.util.ArrayList;
import java.util.List;

public class Cells {

    /**
     * A colony of eight houses, represented as cells, are arranged in a straight line.
     * Each day every cell competes with its adjacent cells (neighbours).
     * An integer value of 1 represents an active cell and value of 0 represents an inactive cell.
     * If both the neighbours are either active or inactive, the cell becomes inactive the next day;
     * otherwise it becomes active on the next day. The two cells on the ends have a single adjacent cell,
     * so the other adjacent cell can be assumed to be always inactive. Even after updating the cell state,
     * its previous state is considered for updating the state of other cells.
     * The cell information of all cells should be updated simultaneously.
     *
     * Write an algorithm to output the state of the cells after the given number of days.
     *
     * @param states a list of integers representing the current state of cells.
     * @param days an integer representing the number of days.
     * @return Return a list of integers representing the state of the cells after the given number of days.
     */
    public List<Integer> cellCompete(int[] states, int days) {
        if (days == 0) {
            int[] result = new int[states.length];
            for (int position = 0; position < states.length; position++) {
                result[position] = (states[position]);
            }
        } else {
            while (days > 0) {
                int[] result = new int[states.length];
                for (int position = 0; position < states.length; position++) {
                    int newValue;
                    int left = evalLeft(position, states);
                    int right = evalRight(position, states);
                    newValue = evalToFlip(left, right, states[position]);
                    result[position] = (newValue);
                }
                days--;
                states = result;
            }
        }
        ArrayList<Integer> newList = convertArrayToList(states);
        return newList;
    }

    private int evalToFlip(int left, int right, int currentValue) {
        if (left == right) {
            return 0;
        } else {
            return 1;
        }
    }

    private int evalLeft(int position, int[] states){
        try {
            return states[position - 1];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    private int evalRight(int position, int[] states){
        try {
            return states[position + 1];
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }
    }

    public ArrayList<Integer> convertArrayToList(int[] values) {
        ArrayList<Integer> newList = new ArrayList<>();
        for (int value : values) {
            newList.add(value);
        }
        return newList;
    }

}