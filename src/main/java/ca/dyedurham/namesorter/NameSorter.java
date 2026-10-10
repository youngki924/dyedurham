package ca.dyedurham.namesorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Sorts by family name, then each given name from left to right. */
public final class NameSorter {
    private static final Comparator<String> PART_ORDER =
            String.CASE_INSENSITIVE_ORDER.thenComparing(Comparator.naturalOrder());

    public List<PersonName> sort(List<PersonName> names) {
        List<PersonName> result = new ArrayList<>(names);
        result.sort((left, right) -> {
            int comparison = PART_ORDER.compare(left.familyName(), right.familyName());
            for (int i = 0; comparison == 0 && i < Math.min(left.givenNames().size(), right.givenNames().size()); i++) {
                comparison = PART_ORDER.compare(left.givenNames().get(i), right.givenNames().get(i));
            }
            if (comparison == 0) comparison = Integer.compare(left.givenNames().size(), right.givenNames().size());
            return comparison;
        });
        return List.copyOf(result);
    }
}
