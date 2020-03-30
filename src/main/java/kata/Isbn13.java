package kata;

import java.util.ArrayList;
import java.util.List;

class Isbn13 extends Isbn {

    Isbn13(String isbn) {
        super(isbn);
    }

    @Override
    void validateChecksum(String isbn) {
        final List<Integer> integers = this.toIndividualDigits(isbn);
        final int calculatedChecksum = this.calculateChecksum(integers);
        final int actualChecksum = this.parseActualChecksum(integers);

        if (calculatedChecksum != actualChecksum) {
            throw new IllegalArgumentException(
                    String.format("expected checksum to be %d but was %d", actualChecksum, calculatedChecksum));
        }
    }

    protected List<Integer> toIndividualDigits(String input) {
        final List<Integer> integers = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            integers.add(Character.getNumericValue(inputChar));
        }
        return integers;
    }

    private int calculateChecksum(List<Integer> digits) {
        final int sum = sumOfProducts(digits);
        return (10 - (sum % 10)) % 10;
    }

    private static int sumOfProducts(List<Integer> digits) {
        int sum = 0;
        for (int i = 0; i < digits.size() - 1; i = i + 2) {
            sum += valueForOddPositionDigit(digits.get(i));
        }
        for (int i = 1; i < digits.size() - 1; i = i + 2) {
            sum += valueForEvenPositionDigit(digits.get(i));
        }
        return sum;
    }

    private static int valueForOddPositionDigit(int digit) {
        return digit;
    }

    private static int valueForEvenPositionDigit(int digit) {
        return digit * 3;
    }

    private Integer parseActualChecksum(List<Integer> digits) {
        return digits.get(digits.size() - 1);
    }
}
