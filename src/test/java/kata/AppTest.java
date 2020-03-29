package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppTest {

  @Test
  void invalid_isbn() {
    assertThrows(IllegalArgumentException.class, () -> Isbn.from("978047005902"));
  }

  @Test
  void invalid_isbn_more_than_13_digits() {
    assertThrows(IllegalArgumentException.class, () -> Isbn.from("97804700590291"));
  }

  @Test
  void invalid_isbn_when_input_contains_non_digits() {
    assertThrows(IllegalArgumentException.class, () -> Isbn.from("978047005902a"));
  }

  @Test
  void valid_isbn_can_contain_dashes() {
    Isbn.from("978-0596809485");
  }

  @Test
  void valid_isbn_can_contain_spaces() {
    Isbn.from("978 0 471 48648 0");
  }

  @Test
  void valid_isbn_needs_correct_checksum() {
      assertThrows(IllegalArgumentException.class, () -> Isbn.from("9780470059020"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"978-0596809485",
      "978 0 471 48648 0",
      "978-0596809485",
      "978-0-13-149505-0",
      "978-0-262-13472-9"})
  void valid_isbns(String input) {
    Isbn.from(input);
  }

    @Test
    void valid_isbn_10() {
      Isbn.from("0471958697");
    }
}
