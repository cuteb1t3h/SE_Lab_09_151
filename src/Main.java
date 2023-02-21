import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет, " + args[0]);

        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextFloat();
        double y = scanner.nextFloat();

        double result = (3 * Math.pow(Math.cos(x - (Math.PI/6)), 2)/(0.5 + Math.pow(Math.sin(y),2)));

        System.out.println(result);
    }
}
