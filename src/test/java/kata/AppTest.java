package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    void valid_isbn_needs_correct_checksum_() {
        assertThat(isIsbn("9780470059029")).isTrue();
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

        int sum = 0;
        final ArrayList<Integer> integers = new ArrayList<>();
        for (char inputChar : input.toCharArray()) {
            integers.add(Character.getNumericValue(inputChar));
        }
        for (int i = 0; i < integers.size() - 1; i=i+2) {
            sum += integers.get(i);

        }
        for (int i = 1; i < integers.size() -1 ; i=i+2) {
            sum += integers.get(i) * 3;

        }
        int result = (10 - (sum % 10)) % 10;

        return result == integers.get(12);
    }

    private String replace(String input, String target) {
        return input.replace(target, "");
    }
}
