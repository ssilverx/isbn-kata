package kata;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ShoppingBasket {

  private List<Book> all = new ArrayList<>();

  public ShoppingBasket() {
  }

  public String total() {
    Bundles bundles = Bundles.from(all);
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(bundles.total());
  }

  public void put(Book book) {
    all.add(book);
  }
}
