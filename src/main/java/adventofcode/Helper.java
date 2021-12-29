package adventofcode;

import java.io.InputStream;

public class Helper {

    public static InputStream getFileAsIOStream(final String fileName)
    {
        InputStream ioStream = new Helper().getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }
}
