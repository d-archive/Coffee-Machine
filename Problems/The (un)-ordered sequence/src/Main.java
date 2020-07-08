import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ascending = true;
        boolean ordered = true;

        int current = scanner.nextInt();
        int next = scanner.nextInt();

        while (current == next && scanner.hasNext()) {
            current = next;
            next = scanner.nextInt();
        }

        if (current > next) {
            ascending = false;
        }

        while (next != 0 && scanner.hasNext()) {
            if (current < next && !ascending) {
                ordered = false;
                break;
            }

            if (current > next && ascending) {
                ordered = false;
                break;
            }

            current = next;
            next = scanner.nextInt();
        }

        System.out.println(ordered);
    }
}


