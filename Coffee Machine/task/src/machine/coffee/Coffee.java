package machine.coffee;

public class Coffee {
  int water;
  int milk;
  int coffeeBeans;
  int price;

  public Coffee(int water, int milk, int coffeeBeans, int price) {
    this.water = water;
    this.milk = milk;
    this.coffeeBeans = coffeeBeans;
    this.price = price;
  }

  public int getWater() {
    return water;
  }

  public int getMilk() {
    return milk;
  }

  public int getCoffeeBeans() {
    return coffeeBeans;
  }

  public int getPrice() {
    return price;
  }
}
