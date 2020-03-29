package kata;

import java.util.ArrayList;
import java.util.List;

class Isbn13 extends Isbn {

    Isbn13(String isbn) {
        super(isbn);
    }

    @Override
    void validateChecksum(String isbn) {
        final List<Integer> integers = toIndividualIntegers(isbn);

        final int sum = sumOfProducts(integers);

        final int calculatedChecksum = (10 - (sum % 10)) % 10;

        if (calculatedChecksum != integers.get(integers.size() - 1)) {
            throw new IllegalArgumentException(
                    String.format("expected checksum to be %d but was %d", integers.get(12), calculatedChecksum));
        }
    }

    private static List<Integer> toIndividualIntegers(String input) {
        final List<Integer> integers = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            integers.add(Character.getNumericValue(inputChar));
        }
        return integers;
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
}
