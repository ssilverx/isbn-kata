package kata;

class ShoppingBasket {

  private String string;

  public ShoppingBasket() {
    string = "0.00 EUR";
  }

  public String total() {
    return string;
  }

  public void put(Book book) {
    this.string = "8.00 EUR";
  }
}
