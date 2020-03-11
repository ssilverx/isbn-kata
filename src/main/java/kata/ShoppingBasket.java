package kata;

import java.util.ArrayList;
import java.util.List;

class ShoppingBasket {

  private String string;

  private List<Book> contents;

  public ShoppingBasket() {
    string = "0.00 EUR";
    contents = new ArrayList<>();
  }

  public String total() {
    int size = contents.size();
    int total = size * 8;
    return total + ".00 EUR";
  }

  public void put(Book book) {
    contents.add(book);
    this.string = "8.00 EUR";
  }
}
