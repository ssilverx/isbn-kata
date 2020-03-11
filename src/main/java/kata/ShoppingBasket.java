package kata;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class ShoppingBasket {

  private List<Bundle> bundles = new ArrayList<>();

  public ShoppingBasket() {
    bundles.add(new Bundle());
  }

  public String total() {
    double result = 0;
    for (Bundle bundle : bundles) {
      result += bundle.total();
    }
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(result);
  }

  public void put(Book book) {
    for (Bundle bundle : bundles) {
      if (!bundle.contains(book)) {
        bundle.add(book);
        return;
      }
    }
    bundles.add(new Bundle(book));
  }
}
