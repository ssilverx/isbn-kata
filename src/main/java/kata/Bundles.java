package kata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Bundles {

  private List<Bundle> bundles;

  private Bundles(Books books) {
    bundles = new ArrayList<>();
    if (books.size() % 5 == 3) {
      fillEvenly(books);
    } else {
      fillEagerly(books);
    }
  }

  public static Bundles from(Books books) {
    return new Bundles(books);
  }

  private void fillEagerly(Books books) {
    for (Book book : books.getBooks()) {
      eagerFilling(book);
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

  private void fillEvenly(Books books) {
    double minBundles = Math.ceil(books.size() / 5.0);
    for (int i = 0; i < minBundles; i++) {
      bundles.add(new Bundle());
    }

    for (Book book : books.getBooks()) {
      evenFilling(book);
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
    bundles.add(new Bundle(book));
  }

  public double total() {
    double result = 0;
    for (Bundle bundle : bundles) {
      result += bundle.total();
    }
    return result;
  }
}
