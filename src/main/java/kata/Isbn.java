package kata;

import java.util.ArrayList;
import java.util.List;

public abstract class Isbn {

    private static final int ISBN_10_LENGTH = 10;
    private static final int ISBN_13_LENGTH = 13;

    private final String value;

    public static Isbn from(final String input) {
        final String sanitizedInput = sanitize(input);
        validateNumericInput(sanitizedInput);

        if (ISBN_13_LENGTH == sanitizedInput.length()) {
            return new Isbn13(sanitizedInput);
        } else if (ISBN_10_LENGTH == sanitizedInput.length()) {
            return new Isbn10(sanitizedInput);
        } else {
            throw new IllegalArgumentException("expected input with 10 or 13 chars");
        }
    }

    Isbn(String value) {
        this.validateChecksum(this.toIndividualIntegers(value));
        this.value = value;
    }

    private static String sanitize(String input) {
        return input.replace("-", "")
                    .replace(" ", "");
    }

    private static void validateNumericInput(String isbn) {
        try {
            Long.parseLong(isbn);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("expected input to only contain digits");
        }
    }

    protected List<Integer> toIndividualIntegers(String input) {
        final List<Integer> integers = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            integers.add(Character.getNumericValue(inputChar));
        }
        return integers;
    }

    abstract void validateChecksum(List<Integer> integers);

    public String getValue() {
        return this.value;
    }
}
