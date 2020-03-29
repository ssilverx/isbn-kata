package kata;

import java.util.ArrayList;

class Isbn {

  static boolean isIsbn(String input) {
    input = input.replace("-", "");
    input = input.replace(" ", "");
    if (input.length() != 13) {
      return false;
    }
    try {
      Long.parseLong(input);
    } catch (NumberFormatException e) {
      return false;
    }

    int sum = 0;
    final ArrayList<Integer> integers = new ArrayList<>();
    for (char inputChar : input.toCharArray()) {
      integers.add(Character.getNumericValue(inputChar));
    }
    for (int i = 0; i < integers.size() - 1; i = i + 2) {
      sum += integers.get(i);
    }
    for (int i = 1; i < integers.size() - 1; i = i + 2) {
      sum += integers.get(i) * 3;
    }
    int result = (10 - (sum % 10)) % 10;

    return result == integers.get(12);
  }
}
