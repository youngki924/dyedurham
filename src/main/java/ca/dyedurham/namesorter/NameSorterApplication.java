package ca.dyedurham.namesorter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

/** Command-line application for sorting names from a text file. */
public final class NameSorterApplication {
    private NameSorterApplication() { }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: name-sorter <input-file>");
            System.exit(2);
        }
        try {
            List<String> lines = Files.readAllLines(Path.of(args[0]), StandardCharsets.UTF_8);
            NameParser parser = new NameParser();
            List<PersonName> names = IntStream.range(0, lines.size())
                    .filter(i -> !lines.get(i).isBlank())
                    .mapToObj(i -> parseLine(parser, lines.get(i), i + 1)).toList();
            List<String> sorted = new NameSorter().sort(names).stream().map(PersonName::asText).toList();
            Files.write(Path.of("sorted-names-list.txt"), sorted, StandardCharsets.UTF_8);
            sorted.forEach(System.out::println);
        } catch (IOException | IllegalArgumentException exception) {
            System.err.println("Unable to sort names: " + exception.getMessage());
            System.exit(1);
        }
    }

    private static PersonName parseLine(NameParser parser, String line, int lineNumber) {
        try {
            return parser.parse(line);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("line " + lineNumber + ": " + exception.getMessage(), exception);
        }
    }
}
