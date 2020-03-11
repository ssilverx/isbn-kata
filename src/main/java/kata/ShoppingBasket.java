package kata;

import java.text.NumberFormat;
import java.util.Locale;

class ShoppingBasket {

  private Bundle twoOrMore = new Bundle();
  private Bundle bundle = new Bundle();

  public ShoppingBasket() {
  }

  public String total() {
    double uniqueTotal = bundle.total();
    double duplicatesTotal = twoOrMore.total();
    double sum = uniqueTotal + duplicatesTotal;
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(sum);
  }

  public void put(Book book) {
    if (bundle.contains(book)) {
      twoOrMore.add(book);
    } else {
      bundle.add(book);
    }
  }
}
