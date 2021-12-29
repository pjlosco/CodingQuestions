package adventofcode.e2021;

import adventofcode.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Dec3 {

    public static void main(final String[] args) throws IOException {
        Dec3 instance = new Dec3();

        InputStream is = Helper.getFileAsIOStream("adventofcode/Dec32021.txt");
        ArrayList<int[]> dataArray = instance.getDataAsArrayList(is);
        System.out.println(instance.getProductOfRate(dataArray));
        int O = instance.oxygenRating(dataArray, true);
        int CO2 = instance.oxygenRating(dataArray, false);
        System.out.println(O * CO2);
    }

    private ArrayList<int[]> getDataAsArrayList(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);)
        {
            ArrayList<int[]> dataArray = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                char[] charArray = line.toCharArray();
                int [] entry = new int[line.length()];
                for(int index = 0; index < charArray.length; index++) {
                    entry[index] = Integer.parseInt("" + charArray[index]);
                }
                dataArray.add(entry);
            }
            is.close();
            return dataArray;
        }
    }

    private int getProductOfRate(ArrayList<int[]> dataArray) {
        int sizeOfList = dataArray.size();
        int[] totalOnes = new int[dataArray.get(0).length];
        for (int[] entry : dataArray) {
            for(int index = 0; index < entry.length; index++) {
                if (entry[index] == 1) {
                    totalOnes[index] = totalOnes[index] + 1;
                }
            }
        }
        StringBuilder gammaBinary = new StringBuilder();
        StringBuilder epsilonBinary = new StringBuilder();
        for (int index = 0; index < totalOnes.length; index++){
            if (totalOnes[index] > sizeOfList/2) {
                gammaBinary.append("1");
                epsilonBinary.append("0");
            } else {
                gammaBinary.append("0");
                epsilonBinary.append("1");
            }
        }
        int gamma = Integer.parseInt(gammaBinary.toString(),2);
        int epsilon = Integer.parseInt(epsilonBinary.toString(),2);
        return gamma * epsilon;
    }

    private int oxygenRating(ArrayList<int[]> dataArray, boolean isMost) {
        // find higher appearance of number in index location
        int lengthOfEntry = dataArray.get(0).length;
        int[] totalOnes = new int[lengthOfEntry]; // unknown for now

        for(int index = 0; index < lengthOfEntry; index++) {
            int sizeOfList = dataArray.size();
            for (int[] entry : dataArray) {
                if (entry[index] == 1) {
                    totalOnes[index] = totalOnes[index] + 1;
                }
            }

            // filter current list to remove all non compliant-bit values
            ArrayList<int[]> filteredDataArray = new ArrayList<>();
            int searchingValue = 0;
            if (isMost) {
                if (totalOnes[index] >= sizeOfList / 2.0) {
                    // 1's are more common
                    searchingValue = 1;
                }
            } else {
                if (totalOnes[index] < sizeOfList / 2.0) {
                    // 1's are less common
                    searchingValue = 1;
                }
            }
            for (int[] entry : dataArray) {
                if (entry[index] == searchingValue) {
                    filteredDataArray.add(entry);
                }
            }
            dataArray = filteredDataArray;
            if (dataArray.size() == 1) {
                break;
            }
        }
        return Integer.parseInt(Arrays.toString(dataArray.get(0)).replaceAll(", ", "").replace("[", "").replace("]", ""),2);
    }
}
