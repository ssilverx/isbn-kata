package bootstrap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    @DisplayName("My first test")
    void my_first_test() {
        assertThat("4" + "2").isEqualTo("42");
    }
}
