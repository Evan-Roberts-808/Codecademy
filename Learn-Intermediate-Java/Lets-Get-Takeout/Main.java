import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Enter your name: ");
    String customerName = input.nextLine();

    int money = 0;
    boolean validInput = false;
    
    while (!validInput) {
      try {
        System.out.print("Enter your starting money: $");
        money = input.nextInt();
        validInput = true;
      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid integer.");
        input.nextLine();
      }
    }

    Customer customer = new Customer(customerName, money);
    TakeOutSimulator takeOutSimulator = new TakeOutSimulator(customer, new FoodMenu(), input);

    takeOutSimulator.startTakeOutSimulator();
    
    input.close();
    }    
} 
