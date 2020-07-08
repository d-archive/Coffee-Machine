import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String withPrefix = scanner.nextLine();
        String withPrefixUppercase = withPrefix.toUpperCase();
        System.out.println(withPrefixUppercase.startsWith("J"));
    }
}