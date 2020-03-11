package kata;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

class ShoppingBasket {

  private List<Bundle> bundles = new ArrayList<>();
  private List<Book> all = new ArrayList<>();

  public ShoppingBasket() {
    bundles.add(new Bundle());
  }

  public String total() {
    bundle();
    double result = 0;
    for (Bundle bundle : bundles) {
      result += bundle.total();
    }
    return NumberFormat.getCurrencyInstance(Locale.GERMANY).format(result);
  }

  public void put(Book book) {
    all.add(book);
  }

  private void bundle() {
    if (all.size() < 8) {
      for (Book book : all) {
        eagerFilling(book);
      }
    } else {
      bundles.add(new Bundle());
      Collections.sort(all);
      for (Book book : all) {
        evenFilling(book);
      }
    }
  }

  private void evenFilling(Book book) {
    bundles.sort(Comparator.comparing(Bundle::size));

    for (Bundle bundle : bundles) {
      if (!bundle.contains(book)) {
        bundle.add(book);
        return;
      }
    }
  }

  private void eagerFilling(Book book) {
    for (Bundle bundle : bundles) {
      if (!bundle.contains(book)) {
        bundle.add(book);
        return;
      }
    }
    bundles.add(new Bundle(book));
  }
}
