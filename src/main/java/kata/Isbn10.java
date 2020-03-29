package kata;

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
    void validateChecksum(List<Integer> integers) {
        final int calculatedChecksum = this.calculateChecksum(integers);
        final int actualChecksum = integers.get(integers.size() - 1);

        if (calculatedChecksum != actualChecksum) {
            throw new IllegalArgumentException(
                    String.format("expected checksum to be %d but was %d", actualChecksum, calculatedChecksum));
        }
    }

    private int calculateChecksum(List<Integer> integers) {
        final int sum = this.sumOfProducts(integers);
        return sum % 11;
    }

    private int sumOfProducts(List<Integer> integers) {
        int sum = 0;
        for (int i = 0; i < integers.size() - 1; i++) {
            sum += integers.get(i) * (i + 1);
        }
        return sum;
    }
}
