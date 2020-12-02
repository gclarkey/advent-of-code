package ie.gc.aoc.input;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileInput implements Input {

    public List<String> fetchInput(final String resourcePath){
        final List<String> input;
        try {
            input = Files.readAllLines(Paths.get(getClass().getResource(resourcePath).toURI()));
        } catch (final IOException e) {
            final String message = "Error reading in file.";
            System.out.println(message);
            throw new RuntimeException(message);
        } catch (final URISyntaxException e) {
            final String message = "Invalid URI.";
            System.out.println(message);
            throw new RuntimeException(message);
        }

        return input;
    }
}
