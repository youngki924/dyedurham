package ca.dyedurham.namesorter;

import java.util.Arrays;

/** Parses and validates a whitespace-delimited name. */
public final class NameParser {
    public PersonName parse(String line) {
        String[] parts = line.trim().split("\\s+");
        if (parts.length < 2 || parts.length > 4) {
            throw new IllegalArgumentException("Expected a family name and one to three given names.");
        }
        return new PersonName(Arrays.asList(parts).subList(0, parts.length - 1), parts[parts.length - 1]);
    }
}
