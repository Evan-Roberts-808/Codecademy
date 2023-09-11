import java.util.Scanner;

// Create TakeOutSimulator class here
public class TakeOutSimulator {
  private Customer customer;
  private FoodMenu menu;
  private Scanner input;

  public TakeOutSimulator(Customer customer, FoodMenu menu, Scanner input){
    this.customer = customer;
    this.menu = menu;
    this.input = input;
  }

  private <T> T getOutputOnIntInput(String userInputPrompt, IntUserInputRetriever<T> intUserInputRetriever) { 
    while (true) {
      System.out.println(userInputPrompt);

      if (input.hasNextInt()) {
        int userInput = input.nextInt();
        input.nextLine();

        try {
          return intUserInputRetriever.produceOutputOnIntUserInput(userInput);
        } catch (IllegalArgumentException e) {
          System.out.println(userInput + " is not a valid input. Try Again.");
        }

      } else {
        input.nextLine();
        System.out.println("Input needs to be an `int` type. Try Again.");
      }

    }
  }

  public boolean shouldSimulate(){
    String userPrompt = "Enter 1 to proceed with simulation, or 0 to stop simulation: ";
    IntUserInputRetriever<Boolean> inputRetriever = (selection) -> {
    if (selection == 1) {
        Food lowestCostFood = menu.getLowestCostFood();
        if (lowestCostFood != null) {
            int lowestCost = lowestCostFood.getPrice();
            int customerMoney = customer.getMoney();
            
            if (customerMoney >= lowestCost) {
                return true;
            }
        }
        return false;
    } else if (selection == 0) {
        return false;
    } else {
        throw new IllegalArgumentException("Invalid selection. Enter 0 or 1.");
    }
};

    return getOutputOnIntInput(userPrompt, inputRetriever);
    }

    public Food getMenuSelection() {
        String userPrompt = generateMenuPrompt();

        IntUserInputRetriever<Food> inputRetriever = (selection) -> {
            Food selectedFood = menu.getFood(selection);
            if (selectedFood != null) {
                return selectedFood;
            } else {
                throw new IllegalArgumentException("Invalid selection. Please choose a valid menu item.");
            }
        };

        return getOutputOnIntInput(userPrompt, inputRetriever);
    }

    // Generate the menu prompt with options
    private String generateMenuPrompt() {
        StringBuilder promptBuilder = new StringBuilder("Today's Menu Options!\n");

        int menuItemNumber = 1;
        for (Food foodItem : menu.getMenu()) {
            promptBuilder.append(menuItemNumber).append(". ").append(foodItem.getName())
                .append(": ").append(foodItem.getDescription())
                .append("    Cost: $").append(foodItem.getPrice()).append("\n");
            menuItemNumber++;
        }

        promptBuilder.append("Choose a menu item!: ");
        return promptBuilder.toString();
    }

        public boolean isStillOrderingFood() {
        String userPrompt = "Enter 1 to CONTINUE shopping or 0 to CHECKOUT: ";

        IntUserInputRetriever<Boolean> inputRetriever = (selection) -> {
            if (selection == 1) {
                return true;
            } else if (selection == 0) {
                return false;
            } else {
                throw new IllegalArgumentException("Invalid selection. Enter 0 or 1.");
            }
        };

        return getOutputOnIntInput(userPrompt, inputRetriever);
    }

    public void checkoutCustomer(ShoppingBag<Food> shoppingBag) { 
      System.out.println("Payment is processing...");

      int totalCost = shoppingBag.getTotalPrice();
      int remainingMoney = customer.getMoney() - totalCost;
      customer.setMoney(remainingMoney);

      System.out.println("Your remaining money: $" + remainingMoney);
      System.out.println("Enjoy your meal!");
    }

        public void takeOutPrompt() {
          ShoppingBag<Food> shoppingBag = new ShoppingBag<>();
          int customerMoneyLeft = customer.getMoney();

          while (true) {
              System.out.println("Money left: $" + customerMoneyLeft);

              Food selectedFood = getMenuSelection();

              if (selectedFood != null && selectedFood.getPrice() <= customerMoneyLeft) {
                  customerMoneyLeft -= selectedFood.getPrice();
                  shoppingBag.addItem(selectedFood);
              } else {
                  System.out.println("You don't have enough money for that item. Pick another item or checkout.");
              }

              boolean continueOrdering = isStillOrderingFood();
              if (!continueOrdering) {
                  break;
              }
          }

        checkoutCustomer(shoppingBag);
    }

        public void startTakeOutSimulator() {
        System.out.println("Welcome to the Take-Out Simulator!");
        System.out.println("Get ready to order some delicious food.");

        while (true) {
            System.out.println("Hello, valued customer!");

            takeOutPrompt();

            boolean continueSimulation = shouldSimulate();
            if (!continueSimulation) {
                System.out.println("Thank you for using the Take-Out Simulator. Enjoy your meal!");
                break;
            }
        }
    }

}