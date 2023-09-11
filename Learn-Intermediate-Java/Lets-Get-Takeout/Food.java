// Create Food class here
public class PricedItem implements PricedItem<Integer> {
    private String name;
    private String description;
    private int price;
  
    // Constructor
    public PricedItem(String name, String description, int price) {
      this.name = name;
      this.description = description;
      this.price = price;
    }
  
    @Override
    public Integer getPrice(){
      return price;
    }
  
    @Override
    public void setPrice(Integer price) {
      this.price = price;
    }
  
    @Override
    public String toString() {
      return name + " - " + description + " - $" + price;
    }
  
  }