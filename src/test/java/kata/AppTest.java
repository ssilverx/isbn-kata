package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppTest {

  @Test
  void invalid_isbn() {
    assertThat(Isbn.isValid("978047005902")).isFalse();
  }

  @Test
  void invalid_isbn_more_than_13_digits() {
    assertThat(Isbn.isValid("97804700590291")).isFalse();
  }

  @Test
  void invalid_isbn_when_input_contains_non_digits() {
    assertThat(Isbn.isValid("978047005902a")).isFalse();
  }

  @Test
  void valid_isbn_can_contain_dashes() {
    assertThat(Isbn.isValid("978-0596809485")).isTrue();
  }

  @Test
  void valid_isbn_can_contain_spaces() {
    assertThat(Isbn.isValid("978 0 471 48648 0")).isTrue();
  }

  @Test
  void valid_isbn_needs_correct_checksum() {
    assertThat(Isbn.isValid("9780470059020")).isFalse();
  }

  @ParameterizedTest
  @ValueSource(strings = {"978-0596809485",
      "978 0 471 48648 0",
      "978-0596809485",
      "978-0-13-149505-0",
      "978-0-262-13472-9"})
  void valid_isbns(String input) {
    assertThat(Isbn.isValid(input)).isTrue();
  }
}
