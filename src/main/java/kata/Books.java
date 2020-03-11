package kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Books {

  private final List<Book> books;

  public Books() {
    books = new ArrayList<>();
  }

  public void add(Book book) {
    books.add(book);
  }

  public int size() {
    return books.size();
  }

  public List<Book> getBooks() {
    Collections.sort(books);
    return new ArrayList<>(books);
  }
}
