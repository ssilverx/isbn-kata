package kata;

import java.util.ArrayList;
import java.util.List;

class Bundle {

  private List<Book> books;

  Bundle() {
    this.books = new ArrayList<>();
  }

  public boolean contains(Book book) {
    return books.contains(book);
  }

  public void add(Book book) {
    books.add(book);
  }

  public double total() {
    double result;
    if (books.size() == 1) {
      result = 8.00d;
    } else if (books.size() == 2) {
      result = books.size() * 8.00d * 0.95;
    } else if (books.size() == 3) {
      result = books.size() * 8.00d * 0.90;
    } else if (books.size() == 4) {
      result = books.size() * 8.00d * 0.80;
    } else {
      result = books.size() * 8.00d * 0.75;
    }
    return result;
  }
}
