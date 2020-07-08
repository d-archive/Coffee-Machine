import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int maxDivisibleByFour = 0;
        for (int i = 0; i < length; i++) {
            int number = scanner.nextInt();
            if (number % 4 == 0 && number > maxDivisibleByFour) {
                maxDivisibleByFour = number;
            }
        }
        System.out.println(maxDivisibleByFour);
    }
}