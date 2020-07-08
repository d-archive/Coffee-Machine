//put imports you need here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.next();
        scanner.next();
        scanner.next();
        scanner.next();
        String cousinePreference = scanner.next();

        System.out.println("The form for " + firstName + " is completed. " +
                "We will contact you if we need a chef " +
                "that cooks " + cousinePreference + " dishes.");

    }
}