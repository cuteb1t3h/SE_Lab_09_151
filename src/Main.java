import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Привет, " + args[0]);

//        Scanner scanner = new Scanner(System.in);
//        double x = scanner.nextFloat();
//        double y = scanner.nextFloat();
//
//        double result = (3 * Math.pow(Math.cos(x - (Math.PI/6)), 2)/(0.5 + Math.pow(Math.sin(y),2)));
//
//        System.out.println(result);


        Scanner scanner = new Scanner(System.in);
        String var = scanner.nextLine();
        double result;
        System.out.println("a = ");
        double a = scanner.nextDouble();
        System.out.println("b = ");
        double b = scanner.nextDouble();
        System.out.println("c = ");
        double c = scanner.nextDouble();
        System.out.println("d = ");
        double d = scanner.nextDouble();
        System.out.println("o = ");
        double o = scanner.nextDouble();
        System.out.println("x = ");
        double x = scanner.nextDouble();
        System.out.println("y = ");
        double y = scanner.nextDouble();
        System.out.println("n = ");
        double n = scanner.nextDouble();

        switch (var) {
            case "V1":
                result = ((Math.pow((5 * a), n * x)) / (b + c)) - (Math.sqrt(Math.abs(Math.pow(Math.cos(x), 3))));
                System.out.println(result);
            case "V2":
                result = ((Math.abs(x - y)) / Math.pow((1 + 2 * x), a)) - Math.pow(Math.E, Math.sqrt(1 + o));
                System.out.println(result);
            case "V3":
                result = Math.sqrt(a + a * x + a * Math.sqrt(Math.sin(x)));
                System.out.println(result);
            case "V4":
                result = Math.log10(Math.pow(a, 7)) + Math.pow((Math.acos(x) / Math.asin(x)), 2) + Math.PI / Math.sqrt(Math.abs(a + x));
                System.out.println(result);
            case "V5":
                result = Math.pow(((Math.pow(a + b, 2)) / c + d) + Math.pow(Math.E, (Math.sqrt(x + 1))), 1.0 / 5);
                System.out.println(result);
            case "V6":
                result = Math.pow(Math.E, (2 * Math.sin(4 * x) + Math.pow(Math.cos(Math.pow(x, 2)), 2)) / (3 * x));
                System.out.println(result);
            case "V7":
                result = 0.75 * (((1 + Math.pow(x, 2)) / (1 - x)) + 0.5 * Math.tan(x));
                System.out.println(result);
        }
    }
}
