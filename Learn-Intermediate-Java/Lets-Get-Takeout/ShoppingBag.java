import java.util.HashMap;
import java.util.Map;

// Create ShoppingBag class here
public class ShoppingBag<T extends PricedItem<Integer>>{
  private Map<T, Integer> shoppingBag;

  public ShoppingBag(){
    shoppingBag = new HashMap<>();
  }

  public void addItem(T item){
    if (shoppingBag.containsKey(item)) {
      int currentQuantity = shoppingBag.get(item);
      shoppingBag.put(item, currentQuantity + 1);
    } else {
      shoppingBag.put(item, 1);
    }
  }

  public Integer getTotalPrice(){
    int total;
    for (Map.Entry<T, Integer> entry : shoppingBag.entrySet()) {
      T item = entry.getKey();
      int quantity = entry.getValue();
      int itemPrice = entry.getPrice();

      int totalItemPrice = quantity * itemPrice;

      total += totalItemPrice;

    }
    return total;
  }

}