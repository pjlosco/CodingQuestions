package adventofcode.e2021;

import adventofcode.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Dec1 {

    public static void main(final String[] args) throws IOException {
        Dec1 instance = new Dec1();

        InputStream is = Helper.getFileAsIOStream("adventofcode/Dec12021.txt");
        ArrayList<Integer> dataArray = instance.getDataAsArrayList(is);
        System.out.println(instance.getIncreasedDepths(dataArray, 1));
        System.out.println(instance.getIncreasedDepths(dataArray, 3));

    }

    private ArrayList<Integer> getDataAsArrayList(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);)
        {
            ArrayList<Integer> dataArray = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                int nextDepth = Integer.parseInt(line);
                dataArray.add(nextDepth);
            }
            is.close();
            return dataArray;
        }
    }

    private int getIncreasedDepths(ArrayList<Integer> dataArray, int sampleWindowSize) {
        int increases = 0;
        int previousSum = 0;
        for (int currentDepth = 0; currentDepth < dataArray.size(); currentDepth++) {
            int sum = 0;
            for (int windowPosition = 0; windowPosition < sampleWindowSize; windowPosition++) {
                try {
                    sum = sum + dataArray.get(currentDepth + windowPosition);
                } catch (IndexOutOfBoundsException e) {
                    // do nothing
                }
            }
            if (previousSum != 0 && sum > previousSum) {
                increases++;
            }
            previousSum = sum;
        }
        return increases;
    }

}
