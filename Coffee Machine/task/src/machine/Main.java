package machine;

import java.util.Scanner;

import static machine.State.*;
import static machine.State.STDB;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CoffeeMachine coffeeMachine = new CoffeeMachine();

    while (true) {
      System.out.println("Write action (buy, fill, take, remaining, exit):");

      String action = scanner.next();
      String input = "";

      if (action.equals("buy")) {
        coffeeMachine.setState(BUY);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        input = scanner.next();
        if (input.equals("back")) {
          continue;
        }
      } else if (action.equals("fill")) {
        coffeeMachine.setState(FILL);
        System.out.println("Write how many ml of water do you want to add:");
        input += scanner.next() + " ";
        System.out.println("Write how many ml of milk do you want to add:");
        input += scanner.next() + " ";
        System.out.println("Write how many grams of coffee beans do you want to add:");
        input += scanner.next() + " ";
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        input += scanner.next() + " ";
      } else if (action.equals("take")) {
        coffeeMachine.setState(TAKE);
      } else if (action.equals("remaining")) {
        coffeeMachine.setState(STDB);
      } else if (action.equals("exit")) {
        break;
      } else {
        System.out.println("Sorry, I do not understand! :(");
        continue;
      }

      coffeeMachine.method(input);
    }
  }
}

