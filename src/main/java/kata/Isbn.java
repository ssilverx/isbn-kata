package kata;

import java.util.ArrayList;
import java.util.List;

class Isbn {

    private final String isbn;

    public Isbn(String isbn) {
        this.isValid(isbn);
        this.isbn = isbn;
    }

    void isValid(String input) {
        input = sanitize(input, "-");
        input = sanitize(input, " ");
        validateLength(input);

        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("expected input to only contain digits");
        }

        final List<Integer> integers = toIndividualIntegers(input);

        int sum = sumOfProducts(integers);

        int calculatedChecksum = (10 - (sum % 10)) % 10;

        if (calculatedChecksum != integers.get(12)) {
            throw new IllegalArgumentException(
                    String.format("expected checksum to be %d but was %d", integers.get(12), calculatedChecksum));
        }
    }

    private static void validateLength(String input) {
        if (input.length() != 13) {
            throw new IllegalArgumentException("expected input with 13 chars");
        }
    }

    private static int sumOfProducts(List<Integer> integers) {
        int sum = 0;
        for (int i = 0; i < integers.size() - 1; i = i + 2) {
            sum += valueForOddPositionDigit(integers.get(i));
        }
        for (int i = 1; i < integers.size() - 1; i = i + 2) {
            sum += valueForEvenPositionDigit(integers.get(i));
        }
        return sum;
    }

    private static int valueForEvenPositionDigit(Integer integer) {
        return integer * 3;
    }

    private static Integer valueForOddPositionDigit(Integer integer) {
        return integer;
    }

    private static List<Integer> toIndividualIntegers(String input) {
        final List<Integer> integers = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            integers.add(Character.getNumericValue(inputChar));
        }
        return integers;
    }

    private static String sanitize(String input, String s) {
        return input.replace(s, "");
    }
}
