package kata;

import java.text.NumberFormat;
import java.util.Locale;

class ShoppingBasket {

  private Bundle firstBundle = new Bundle();
  private Bundle secondBundle = new Bundle();
  private Bundle thirdBundle = new Bundle();

  public ShoppingBasket() {
  }

  public String total() {
    double sum = firstBundle.total() + secondBundle.total() + thirdBundle.total();
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(sum);
  }

  public void put(Book book) {
    if (!firstBundle.contains(book)) {
      firstBundle.add(book);
    } else if (!secondBundle.contains(book)) {
      secondBundle.add(book);
    } else {
      thirdBundle.add(book);
    }
  }
}
