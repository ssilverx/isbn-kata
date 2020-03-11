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
    int size = contents.size();
    double total = size * 8.00d;
    NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.GERMANY);
    return currencyInstance.format(total);
  }

  public void put(Book book) {
    contents.add(book);
  }
}
