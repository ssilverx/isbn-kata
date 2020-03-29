package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AppTest {

    @Test
    void invalid_isbn() {
        assertThat(isIsbn("978047005902")).isFalse();
    }

    @Test
    void invalid_isbn_more_than_13_digits() {
        assertThat(isIsbn("97804700590291")).isFalse();
    }

    @Test
    void invalid_isbn_when_input_contains_non_digits() {
        assertThat(isIsbn("978047005902a")).isFalse();
    }

    @Test
    void valid_isbn_can_contain_dashes() {
        assertThat(isIsbn("978-0596809485")).isTrue();
    }

    @Test
    void valid_isbn_can_contain_spaces() {
        assertThat(isIsbn("978 0 471 48648 0")).isTrue();
    }

    @Test
    void valid_isbn_needs_correct_checksum() {
        assertThat(isIsbn("9780470059020")).isFalse();
    }

    private boolean isIsbn(String input) {
        input = replace(input, "-");
        input = replace(input, " ");
        if (input.length() != 13) {
            return false;
        }
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            return false;
        }

        // by multiplying each digit alternately by 1 or 3
        // (i.e., 1 x 1st digit, 3 x 2nd digit, 1 x 3rd digit, 3 x 4th digit, etc.),
        // summing these products together,
        // taking modulo 10 of the result
        //and subtracting this value from 10,
        // and then taking the modulo 10 of the result again to produce a single digit.

        return true;
    }

    private String replace(String input, String target) {
        return input.replace(target, "");
    }
}
