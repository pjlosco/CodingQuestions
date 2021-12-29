package adventofcode.e2021;

import adventofcode.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * https://adventofcode.com/2021/day/4
 */
public class Dec4 {

    private class BingoBoard {
        ArrayList<Set<Integer>> rows;
        ArrayList<Set<Integer>> columns;

        BingoBoard(int[][] board) {
            for (int xIndex = 0; xIndex < 5; xIndex++) {
                Set<Integer> numberSet = new HashSet<>();
                for (int yIndex = 0; yIndex < 5; yIndex++) {
                    numberSet.add(board[xIndex][yIndex]);
                }
                rows.add(numberSet);
            }
            for (int yIndex = 0; yIndex < 5; yIndex++) {
                Set<Integer> numberSet = new HashSet<>();
                for (int xIndex = 0; xIndex < 5; xIndex++) {
                    numberSet.add(board[xIndex][yIndex]);
                }
                columns.add(numberSet);
            }
        }

        public int getFinalScore(int lastNumber, Set<Integer> drawnNumbers)  {
            for (Set<Integer> candidateSet : rows) {
                for (int candidate : candidateSet) {
                    if (drawnNumbers.contains(candidate)) {
                        Set<Integer> remainingNumbers = new HashSet<>();
                        for (Set<Integer> intSet : rows) {
                            remainingNumbers.addAll(intSet);
                        }
                        remainingNumbers.removeAll(winningNumbers);
                        return remainingNumbers;
                    }
                }
            }
        }
    }

    ArrayList<Integer> orderOfNumbers;
    ArrayList<int[][]> bingoBoards;

    int winningNumber = 0;

    public static void main(final String[] args) throws IOException {
        Dec4 instance = new Dec4();

        InputStream is = Helper.getFileAsIOStream("adventofcode/Dec42021.txt");
        instance.setData(is);
        Set<Integer> winningBoard = instance.getWinningBoard();
        if (winningBoard == null) {
            System.out.println("No winning board found");
            System.exit(1);
        }
        System.out.println(getFinalScore(winningBoard, instance.winningNumber));
    }

    private void setData(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);)
        {
            String[] firstline = br.readLine().trim().split(",");
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String item : firstline) {
                numbers.add(Integer.parseInt(item));
            }
            this.orderOfNumbers = numbers;

            ArrayList<int[][]> bingoBoards = new ArrayList<>();

            String line;

            int[][] board = new int[5][5];
            int boardLine = 0;

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }
                String[] items = line.trim().split("\\s+");
                if (items.length == 5) {
                    for (int index = 0; index < 5; index++) {
                        board[boardLine][index] = Integer.parseInt(items[index]);
                    }
                    boardLine++;
                }
                if (boardLine == 5) {
                    bingoBoards.add(board);
                    boardLine = 0;
                    board = new int[5][5];
                }
            }

            this.bingoBoards = bingoBoards;
            is.close();
        }


    }

    private Set<Integer> getWinningBoard() {
        Set<Integer> drawnNumbers = new HashSet<>();
        ArrayList<BingoBoard> setOfBoards = getBoardsAsList(this.bingoBoards);
        for (int number : orderOfNumbers) {
            // going through the numbers
            drawnNumbers.add(number);
            if (drawnNumbers.size() < 5) {
                continue;
            }
            for (BingoBoard board : setOfBoards) {
                for (Set<Integer> candidateSet : board.rows) {
                    for (int candidate : candidateSet) {
                        if (drawnNumbers.contains(candidate)) {
                            winningNumber = number;
                            return getRemainingNumbers(board, candidateSet);
                        }
                    }
                }
            }
        }
        return null;
    }

    private ArrayList<BingoBoard> getBoardsAsList(ArrayList<int[][]>  boards) {
        ArrayList<BingoBoard> bingoBoards = new ArrayList<>();
        for (int[][] board : boards) {
            bingoBoards.add(new BingoBoard(board));
        }
        return bingoBoards;
    }

    private Set<Integer> getRemainingNumbers(Set<Set<Integer>> board, Set<Integer> winningNumbers) {
        Set<Integer> remainingNumbers = new HashSet<>();
        for (Set<Integer> intSet : board) {
            remainingNumbers.addAll(intSet);
        }
        remainingNumbers.removeAll(winningNumbers);
        return remainingNumbers;
    }

    private static int getFinalScore(Set<Integer> set, int winningNumber) {
//        int sum = 0;
//        for (int xIndex = 0; xIndex < 5; xIndex++) {
//            for (int yIndex = 0; yIndex < 5; yIndex++) {
//                sum = sum + board[xIndex][yIndex];
//            }
//        }
        int sum = set.stream().mapToInt(Integer::intValue).sum();

        return sum * winningNumber;
    }
}
