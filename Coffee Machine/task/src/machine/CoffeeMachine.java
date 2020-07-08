package machine;

import machine.coffee.Cappuccino;
import machine.coffee.Coffee;
import machine.coffee.Espresso;
import machine.coffee.Latte;

import java.util.ArrayList;
import java.util.Optional;

import static machine.State.*;

public class CoffeeMachine {
  int water;
  int milk;
  int coffeeBeans;
  int cups;
  int money;
  State state;

  public CoffeeMachine() {
    this.water = 400;
    this.milk = 540;
    this.coffeeBeans = 120;
    this.cups = 9;
    this.money = 550;
  }

  public void method(String input) {
    if (state == BUY) {
      makeCoffee(input);
    } else if (state == FILL) {
      String[] s = input.split(" ");
      try {
        fill(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]));
      } catch (NumberFormatException e) {
        System.out.println("Please use only numbers");
      }
    } else if (state == TAKE) {
      int m = money;
      emptyCashRegister();
      System.out.println(String.format("I gave you $%s", m));
    } else if (state == STDB) {
      printState();
    }
  }

  private void makeCoffee(String coffeeCode) {
    Coffee coffee = null;
    if (coffeeCode.equals("1")) {
      coffee = new Espresso();
    } else if (coffeeCode.equals("2")) {
      coffee = new Latte();
    } else if (coffeeCode.equals("3")) {
      coffee = new Cappuccino();
    } else {
      System.out.println("Error! - Choose one of those: 1,2,3");
    }

    Optional.ofNullable(coffee).ifPresent(c -> {
      int w = c.getWater();
      int m = c.getMilk();
      int cb = c.getCoffeeBeans();
      int p = c.getPrice();

      if (canMakeCoffee(w, m, cb)) {
        System.out.println("I have enough resources, making you a coffee!");
        this.water -= w;
        this.milk -= m;
        this.coffeeBeans -= cb;
        this.money += p;
        this.cups--;
      }
    });
  }

  private void fill(int water, int milk, int coffeeBeans, int cups) {
    this.water += water;
    this.milk += milk;
    this.coffeeBeans += coffeeBeans;
    this.cups += cups;
  }

  private void emptyCashRegister() {
    money = 0;
  }

  private boolean canMakeCoffee(int w, int m, int cb) {
    int waterForCoffee = 1;
    int milkForCoffee = 1;
    int beansForCoffee = 1;

    if (w > 0) {
      waterForCoffee = water / w;
    }

    if (m > 0) {
      milkForCoffee = milk / m;
    }

    if (cb > 0) {
      beansForCoffee = coffeeBeans / cb;
    }

    ArrayList errors = new ArrayList();

    if (waterForCoffee < 1) {
      errors.add("Sorry, not enough water!");
    }

    if (beansForCoffee < 1) {
      errors.add("Sorry, not enough coffee beans!");
    }

    if (milkForCoffee < 1) {
      errors.add("Sorry, not enough milk!");
    }

    if (cups < 1) {
      errors.add("Sorry, not enough cups!");
    }

    if (errors.isEmpty()) {
      return true;
    } else {
      errors.forEach(System.out::println);
      errors.clear();
      return false;
    }
  }

  public void setState(State state) {
    this.state = state;
  }

  private void printState() {
    System.out.println("The coffee machine has:");
    System.out.println(String.format("%s of water", water));
    System.out.println(String.format("%s of milk", milk));
    System.out.println(String.format("%s of coffee beans", coffeeBeans));
    System.out.println(String.format("%s of disposable cups", cups));
    System.out.println(String.format("$%s of money", money));
  }
}
