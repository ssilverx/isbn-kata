package kata;

import java.util.ArrayList;
import java.util.List;

class Bundle {

  private List<Book> books = new ArrayList<>();

  Bundle() {
  }

  public Bundle(Book book) {
    books.add(book);
  }

  public boolean contains(Book book) {
    return books.contains(book);
  }

  public void add(Book book) {
    books.add(book);
  }

  public double total() {
    return books.size() * 8.00d * discount();
  }

  public int size() {
    return books.size();
  }

  private double discount() {
    double result = 0;
    if (books.size() == 1) {
      result = 1.00;
    } else if (books.size() == 2) {
      result = 0.95;
    } else if (books.size() == 3) {
      result = 0.90;
    } else if (books.size() == 4) {
      result = 0.80;
    } else if (books.size() == 5) {
      result = 0.75;
    }
    return result;
  }
}
