package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppTest {

  @Test
  void invalid_isbn() {
    assertThat(Isbn.isIsbn("978047005902")).isFalse();
  }

  @Test
  void invalid_isbn_more_than_13_digits() {
    assertThat(Isbn.isIsbn("97804700590291")).isFalse();
  }

  @Test
  void invalid_isbn_when_input_contains_non_digits() {
    assertThat(Isbn.isIsbn("978047005902a")).isFalse();
  }

  @Test
  void valid_isbn_can_contain_dashes() {
    assertThat(Isbn.isIsbn("978-0596809485")).isTrue();
  }

  @Test
  void valid_isbn_can_contain_spaces() {
    assertThat(Isbn.isIsbn("978 0 471 48648 0")).isTrue();
  }

  @Test
  void valid_isbn_needs_correct_checksum() {
    assertThat(Isbn.isIsbn("9780470059020")).isFalse();
  }
}
