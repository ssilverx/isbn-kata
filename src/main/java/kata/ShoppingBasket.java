package kata;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ShoppingBasket {

  private List<Book> unique;
  private List<Book> twoOrMore;

  public ShoppingBasket() {
    unique = new ArrayList<>();
    twoOrMore = new ArrayList<>();
  }

  public String total() {
    double uniqueTotal;
    if (unique.size() == 1) {
      uniqueTotal = 8.00d;
    } else if (unique.size() == 2) {
      uniqueTotal = unique.size() * 8.00d * 0.95;
    } else {
      uniqueTotal = unique.size() * 8.00d * 0.90;
    }
    double duplicatesTotal = twoOrMore.size() * 8.00d;
    double sum = uniqueTotal + duplicatesTotal;
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(sum);
  }

  public void put(Book book) {
    if (unique.contains(book)) {
      twoOrMore.add(book);
    } else {
      unique.add(book);
    }
  }
}
