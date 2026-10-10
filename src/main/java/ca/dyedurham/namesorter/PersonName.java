package ca.dyedurham.namesorter;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** A person's one-to-three given names and family name. */
public record PersonName(List<String> givenNames, String familyName) {
    public PersonName {
        givenNames = List.copyOf(Objects.requireNonNull(givenNames, "givenNames"));
        familyName = Objects.requireNonNull(familyName, "familyName");
        if (givenNames.isEmpty() || givenNames.size() > 3 || familyName.isBlank()
                || givenNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException("A name requires a family name and one to three given names.");
        }
    }

    public String asText() {
        return Stream.concat(givenNames.stream(), Stream.of(familyName)).collect(Collectors.joining(" "));
    }
}
