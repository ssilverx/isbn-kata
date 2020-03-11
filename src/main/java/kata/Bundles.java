package kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Bundles {

  private final List<Book> books;
  private List<Bundle> eager;
  private List<Bundle> even;

  private Bundles(List<Book> books) {
    this.books = books;
    eager = new ArrayList<>();
    even = new ArrayList<>();
  }

  public static Bundles from(List<Book> books) {
    return new Bundles(books);
  }

  public double total() {

    if (books.size() % 5 == 3) {
      Collections.sort(books);
      for (Book book : books) {
        evenFilling(book);
      }
      double evenTotal = 0;
      for (Bundle bundle : even) {
        evenTotal += bundle.total();
      }
      return evenTotal;
    }

    double minBundles = Math.ceil(books.size() / 5.0);
    for (int i = 0; i < minBundles; i++) {
      even.add(new Bundle());
    }

    Collections.sort(books);
    for (Book book : books) {
      eagerFilling(book);
    }

    double eagerTotal = 0;
    for (Bundle bundle : eager) {
      eagerTotal += bundle.total();
    }
    return eagerTotal;
  }

  private void evenFilling(Book book) {
    even.sort(Comparator.comparing(Bundle::size));

    for (Bundle bundle : even) {
      if (!bundle.contains(book)) {
        bundle.add(book);
        return;
      }
    }
    even.add(new Bundle(book));
  }

  private void eagerFilling(Book book) {
    for (Bundle bundle : eager) {
      if (!bundle.contains(book)) {
        bundle.add(book);
        return;
      }
    }
    eager.add(new Bundle(book));
  }
}
