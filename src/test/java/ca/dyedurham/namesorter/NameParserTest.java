package ca.dyedurham.namesorter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameParserTest {
    private final NameParser parser = new NameParser();

    @Test
    void parsesOneTwoAndThreeGivenNames() {
        assertEquals("Janet Parsons", parser.parse("Janet Parsons").asText());
        assertEquals("Adonis Julius Archer", parser.parse("Adonis Julius Archer").asText());
        assertEquals("Hunter Uriah Mathew Clarke", parser.parse("Hunter Uriah Mathew Clarke").asText());
    }

    @Test
    void normalizesWhitespaceBetweenNameParts() {
        assertEquals("Janet Parsons", parser.parse("  Janet   Parsons  ").asText());
    }

    @Test
    void rejectsMissingOrMoreThanThreeGivenNames() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("Parsons"));
        assertThrows(IllegalArgumentException.class, () -> parser.parse("One Two Three Four Five"));
    }
}
