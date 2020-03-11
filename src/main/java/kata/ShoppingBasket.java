package kata;

import java.text.NumberFormat;
import java.util.Locale;

class ShoppingBasket {

  private Books books = new Books();

  public ShoppingBasket() {
  }

  public String total() {
    Bundles bundles = Bundles.from(books);
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(bundles.total());
  }

  public void put(Book book) {
    books.add(book);
  }
}
