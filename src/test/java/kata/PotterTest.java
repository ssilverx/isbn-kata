package kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

        assertThat(total).isEqualTo("0,00 €");
    }

    @Test
    void one_book_costs_8_euro() {
        //given
        basket.put(new Book("part 1"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("8,00 €");
    }

    @Test
    void two_same_books_cost_16() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 1"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("16,00 €");
    }

    @Test
    void two_different_books_then_discount_applies() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("15,20 €");
    }

    @Test
    void three_different_books_then_discount_applies() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));
        basket.put(new Book("part 3"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("21,60 €");
    }

    @Test
    void four_different_books_then_discount_applies() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));
        basket.put(new Book("part 3"));
        basket.put(new Book("part 4"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("25,60 €");
    }

    @Test
    void five_different_books_then_discount_applies() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));
        basket.put(new Book("part 3"));
        basket.put(new Book("part 4"));
        basket.put(new Book("part 5"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("30,00 €");
    }

    @Test
    void five_book_bundle_and_two_book_bundle_both_with_discount() {
        //given
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));
        basket.put(new Book("part 1"));
        basket.put(new Book("part 2"));

        //when
        String total = basket.total();

        //then
        assertThat(total).isEqualTo("30,40 €");
    }
}
