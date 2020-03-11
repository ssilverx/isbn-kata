package kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PotterTest {

    private ShoppingBasket basket;

    @BeforeEach
    void setUp() {
        basket = new ShoppingBasket();
    }

    @Test
    void price_is_zero_when_shopping_basket_empty() {
        String total = basket.total();

        assertThat(total).isEqualTo("0.00 EUR");
    }

    @Test
    void one_book_costs_8_euro() {
        //given
        basket.put(new Book("part 1"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("8.00 EUR");
    }

    @Test
    void two_different_books_cost_16_euro() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("16.00 EUR");
    }
}
