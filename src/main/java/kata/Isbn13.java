package kata;

import java.util.List;

class Isbn13 extends Isbn {

    Isbn13(String isbn) {
        super(isbn);
    }

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
        final int sum = sumOfProducts(integers);
        return (10 - (sum % 10)) % 10;
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

    private static int valueForOddPositionDigit(int integer) {
        return integer;
    }

    private static int valueForEvenPositionDigit(int integer) {
        return integer * 3;
    }
}
