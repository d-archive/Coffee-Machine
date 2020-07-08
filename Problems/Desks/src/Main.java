import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstClassStudents = scanner.nextInt();
        int secondClassStudents = scanner.nextInt();
        int thirdClassStudents = scanner.nextInt();
        System.out.println((firstClassStudents / 2) + (firstClassStudents % 2) + (secondClassStudents / 2) + (secondClassStudents % 2) + (thirdClassStudents / 2) + (thirdClassStudents % 2));
    }
}