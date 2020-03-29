package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppTest {

    @ParameterizedTest
    @ValueSource(strings = { "97804700590", "978047005902" })
    void invalid_isbn_if_less_than_13_digits_but_more_than_10(String input) {
        final Throwable thrown = catchThrowable(() -> Isbn.from(input));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("expected input with 10 or 13 chars");
    }

    @Test
    void invalid_isbn_if_more_than_13_digits() {
        final Throwable thrown = catchThrowable(() -> Isbn.from("97804700590291"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("expected input with 10 or 13 chars");
    }

    @Test
    void invalid_isbn_if_less_than_10_digits() {
        final Throwable thrown = catchThrowable(() -> Isbn.from("123456789"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("expected input with 10 or 13 chars");
    }

    @Test
    void invalid_isbn_when_input_contains_non_digits() {
        final Throwable thrown = catchThrowable(() -> Isbn.from("978047005902a"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("expected input to only contain digits");
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
    void valid_isbn_can_have_10_digits() {
        Isbn.from("0 471 60695 2");
    }

    @Test
    void invalid_isbn_13_if_input_has_incorrect_checksum() {
        final Throwable thrown = catchThrowable(() -> Isbn.from("9780470059020"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("expected checksum to be 0 but was 9");
    }

    @Test
    void invalid_isbn_10_if_input_has_incorrect_checksum() {
        final Throwable thrown = catchThrowable(() -> Isbn.from("0471958690"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessage("expected checksum to be 0 but was 7");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "978-0596809485",
            "978 0 471 48648 0",
            "978-0596809485",
            "978-0-13-149505-0",
            "978-0-262-13472-9"})
    void valid_isbns(String input) {
        Isbn.from(input);
    }
}
