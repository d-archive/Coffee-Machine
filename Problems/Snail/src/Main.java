import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int up = scanner.nextInt();
        int down = scanner.nextInt();

        int sum = 0;
        int days = 0;

        while(sum < height) {
            days++;
            sum += up;
            if (sum >= height) {
                System.out.println(days);
                return;
            }
            sum -= down;
        }
    }
}