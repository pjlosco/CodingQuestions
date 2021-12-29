package adventofcode.e2021;

import adventofcode.Helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Locale;

public class Dec2 {

    public enum Direction {
        FORWARD,
        DOWN,
        UP;
    }

    public static void main(final String[] args) throws IOException {
        Dec2 instance = new Dec2();

        InputStream is = Helper.getFileAsIOStream("adventofcode/Dec22021.txt");
        ArrayList<SimpleImmutableEntry<Direction, Integer>> dataArray = instance.getDataAsArrayList(is);
        System.out.println(instance.getProductOfLocation(dataArray));
        System.out.println(instance.getLocationWithAim(dataArray));
    }

    private ArrayList<SimpleImmutableEntry<Direction, Integer>> getDataAsArrayList(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);)
        {
            ArrayList<SimpleImmutableEntry<Direction, Integer>> dataArray = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split(" ");
                Direction direction = Direction.valueOf(data[0].toUpperCase(Locale.ROOT));
                int distance =  Integer.parseInt(data[1]);
                SimpleImmutableEntry<Direction, Integer> entry
                        = new SimpleImmutableEntry<Direction, Integer>(direction, distance);
                dataArray.add(entry);
            }
            is.close();
            return dataArray;
        }
    }

    private int getProductOfLocation(ArrayList<SimpleImmutableEntry<Direction, Integer>> dataArray) {
        int depth = 0;
        int distance = 0;
        for (SimpleImmutableEntry<Direction, Integer> entry : dataArray) {
            if (entry.getKey().equals(Direction.DOWN)) {
                depth = depth + entry.getValue();
            } else if (entry.getKey().equals(Direction.UP)) {
                depth = depth - entry.getValue();
                if (depth < 0) {
                    depth = 0;
                }
            } else if (entry.getKey().equals(Direction.FORWARD)) {
                distance = distance + entry.getValue();
            }
        }

        return depth * distance;
    }

    private int getLocationWithAim(ArrayList<SimpleImmutableEntry<Direction, Integer>> dataArray) {
        int depth = 0;
        int aim = 0;
        int distance = 0;
        for (SimpleImmutableEntry<Direction, Integer> entry : dataArray) {
            if (entry.getKey().equals(Direction.DOWN)) {
                aim = aim + entry.getValue();
            } else if (entry.getKey().equals(Direction.UP)) {
                aim = aim - entry.getValue();
            } else if (entry.getKey().equals(Direction.FORWARD)) {
                distance = distance + entry.getValue();
                depth = depth + (entry.getValue() * aim);
                if (depth < 0) {
                    depth = 0;
                }
            }
        }

        return depth * distance;
    }
}
