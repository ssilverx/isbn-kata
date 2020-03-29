package kata;

import java.util.ArrayList;
import java.util.List;

class Isbn {

  static boolean isValid(String input) {
    input = sanitize(input, "-");
    input = sanitize(input, " ");
    if (input.length() != 13) {
      return false;
    }
    try {
      Long.parseLong(input);
    } catch (NumberFormatException e) {
      return false;
    }

    final List<Integer> integers = toIndividualIntegers(input);

    int sum = sumOfProducts(integers);

    int calculatedChecksum = (10 - (sum % 10)) % 10;

    return calculatedChecksum == integers.get(12);
  }

  private static int sumOfProducts(List<Integer> integers) {
    int sum = 0;
    for (int i = 0; i < integers.size() - 1; i = i + 2) {
      sum += integers.get(i);
    }
    for (int i = 1; i < integers.size() - 1; i = i + 2) {
      sum += integers.get(i) * 3;
    }
    return sum;
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
