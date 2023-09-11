import java.util.ArrayList;
import java.util.List;

// Create FoodMenu class here
public class FoodMenu {
  private List<Food> menu;

  public FoodMenu(){
    menu = new ArrayList<>();

    menu.add(new Food("Pizza", "Delicious cheese pizza", 10));
    menu.add(new Food("Burger", "Juicy beef burger", 8));
    menu.add(new Food("Salad", "Fresh garden salad", 6));
  }

  @Override
  public String toString(){
    StringBuilder menuString = new StringBuilder();

    for(int i = 0; i < menu.size(); i++) {
      Food foodItem = menu.get(i);
      menuString.append(i + 1).append(". ").append(foodItem.getName()).append(" - ").append(foodItem.getDescription()).append(" - $").append(foodItem.getPrice()).append("\n");
    }

    return menuString.toString();
  }

  public Food getFood(int index){
    try {
    int adjusted = index - 1;

    if (adjusted >= 0 && adjusted < menu.size()) {
      return menu.get(adjusted)
    }
  } catch (IndexOutOfBoundsException e) {
    System.out.println("Out of bounds");
    return null;
    }
  return null;
  }

  public Food getLowestCostFood(){
    Food lowestCost = null;

    for (Food foodItem : menu) {
      if(lowestCost == null || foodItem.getPrice() < lowestCost.getPrice()) {
        lowestCost = foodItem;
      }
    }
    return lowestCost;
  }

}