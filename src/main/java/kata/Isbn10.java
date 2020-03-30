package kata;

import java.util.ArrayList;
import java.util.List;

class Isbn10 extends Isbn {

    Isbn10(String isbn) {
        super(isbn);
    }

    /**
     * The check digit for ISBN-10 is calculated by multiplying
     * each digit by its position (i.e., 1 x 1st digit, 2 x 2nd
     * digit, etc.), summing these products together and taking
     * modulo 11 of the result (with 'X' being used if the result
     * is 10).
     */
    @Override
    void validateChecksum(String isbn) {
        final List<Integer> integers = this.toIndividualDigits(isbn);
        final int calculatedChecksum = this.calculateChecksum(integers);
        final int actualChecksum = this.getActualChecksum(integers);

        if (calculatedChecksum != actualChecksum) {
            throw new IllegalArgumentException(
                    String.format("expected checksum to be %d but was %d", actualChecksum, calculatedChecksum));
        }
    }

    protected List<Integer> toIndividualDigits(String input) {
        final List<Integer> integers = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            if ("X".equals(Character.toString(inputChar))) {
                integers.add(10);
            } else {
                integers.add(Character.getNumericValue(inputChar));
            }
        }
        return integers;
    }

    private int calculateChecksum(List<Integer> digits) {
        final int sum = this.sumOfProducts(digits);
        return sum % 11;
    }

    private int sumOfProducts(List<Integer> digits) {
        int sum = 0;
        for (int i = 0; i < digits.size() - 1; i++) {
            sum += digits.get(i) * (i + 1);
        }
        return sum;
    }

    private int getActualChecksum(List<Integer> integers) {
        return integers.get(integers.size() - 1);
    }
}
