package kata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PotterTest {

  @Test
  void price_is_zero_when_shopping_basket_empty() {
    //given
    ShoppingBasket basket = new ShoppingBasket();

    //when
    String total = basket.total();

    //then
    assertThat(total).isEqualTo("0.00 EUR");
  }
}
