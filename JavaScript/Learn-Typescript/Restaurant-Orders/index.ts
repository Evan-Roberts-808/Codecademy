import { restaurants, Restaurant } from "./restaurants";
import { orders, Order, PriceBracket } from "./orders";

/// Add your getMaxPrice() function below:
function getMaxPrice(bracket : PriceBracket) : number {
  switch (bracket) {
    case PriceBracket.Low:
      return 10.0;
    case PriceBracket.Medium:
      return 20.0;
    case PriceBracket.High:
      return 30.0;
    default:
      return 0;
  }
}
/// Add your getOrders() function below:
function getOrders(price: PriceBracket, orders: Order[][]) {
  return orders.map(restaurant => restaurant.filter(order => order.price <= getMaxPrice(price)))
}
/// Add your printOrders() function below:
function printOrders(restaurants: Restaurant[], orders: Order[][]): void {
  restaurants.forEach((restaurant, index) => {
    if (orders[index].length) {
      console.log(restaurant.name);
      orders[index].forEach(({ name, price }) => {
        console.log(`- ${name}: $${price}`);
      });
    }
  });
}
/// Main
const elligibleOrders = getOrders(PriceBracket.Low, orders);
printOrders(restaurants, elligibleOrders);
