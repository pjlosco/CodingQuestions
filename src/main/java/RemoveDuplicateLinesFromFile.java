import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLinesFromFile {

    public RemoveDuplicateLinesFromFile(File file) {
        // read in file
        try {
            BufferedReader br =  new BufferedReader(new FileReader(file));
            Set<String> lines = new HashSet<String>();
            PrintWriter writer = new PrintWriter("output-file.txt", "UTF-8");
            for(String line; (line = br.readLine()) != null; ) {
                if (!line.isEmpty()) {
                    if (!lines.contains(line)) {
                        lines.add(line);
                        writer.println(line);
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
