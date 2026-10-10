package ca.dyedurham.namesorter;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NameSorterTest {
    private final NameParser parser = new NameParser();

    @Test
    void sortsByFamilyNameThenGivenNames() {
        var input = List.of(parser.parse("Janet Parsons"), parser.parse("Vaugh Lewis"),
                parser.parse("Adonis Julius Archer"), parser.parse("Beau Tristan Bentley"),
                parser.parse("Marin Alvarez"), parser.parse("London Lindsey"), parser.parse("Leo Gardner"));
        assertEquals(List.of("Marin Alvarez", "Adonis Julius Archer", "Beau Tristan Bentley",
                        "Leo Gardner", "Vaugh Lewis", "London Lindsey", "Janet Parsons"),
                new NameSorter().sort(input).stream().map(PersonName::asText).toList());
    }

    @Test
    void rejectsInvalidNameLengths() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("Parsons"));
        assertThrows(IllegalArgumentException.class, () -> parser.parse("One Two Three Four Five"));
    }
}
