package kata;

public abstract class Isbn {

    private static final int ISBN_10_LENGTH = 10;
    private static final int ISBN_13_LENGTH = 13;

    private final String isbn;

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

    Isbn(String isbn) {
        this.validateChecksum(isbn);
        this.isbn = isbn;
    }

    abstract void validateChecksum(String isbn);

    private static String sanitize(String input) {
        return input.replace("-", "")
                    .replace(" ", "");
    }

    private static void validateNumericInput(String isbn) {
        if (isbn.length() == 10 && isbn.endsWith("X")) {
            final String digitsPart = isbn.substring(0, isbn.length() - 1);
            parseOrThrow(digitsPart);
        } else {
            parseOrThrow(isbn);
        }
    }

    private static void parseOrThrow(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("expected input to only contain digits");
        }
    }

    public String getIsbn() {
        return this.isbn;
    }
}
