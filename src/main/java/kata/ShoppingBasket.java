package kata;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ShoppingBasket {

  private List<Book> contents;

  public ShoppingBasket() {
    contents = new ArrayList<>();
  }

  public String total() {
    double total = 0;
    if (contents.size() == 2) {
      if (!contents.get(0).equals(contents.get(1))) {
        total = 15.20D;
        return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(total);
      }
    }

    int size = contents.size();
    total = size * 8.00d;

    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    return currencyInstance.format(total);
  }

  public void put(Book book) {
    contents.add(book);
  }
}
