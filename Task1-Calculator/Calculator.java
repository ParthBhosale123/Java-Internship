import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return Double.NaN;
        }
        return a / b;
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static double squareRoot(double a) {
        if (a < 0) {
            System.out.println("Error: Negative number cannot have a real square root!");
            return Double.NaN;
        }
        return Math.sqrt(a);
    }

    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Error: Factorial of negative number not defined!");
            return -1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("===== Advanced Calculator =====");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power (x^y)");
            System.out.println("6. Square Root");
            System.out.println("7. Factorial");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            double num1, num2;
            long resultFact;

            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + add(num1, num2));
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + subtract(num1, num2));
                    break;
                case 3:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + multiply(num1, num2));
                    break;
                case 4:
                    System.out.print("Enter two numbers: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + divide(num1, num2));
                    break;
                case 5:
                    System.out.print("Enter base and exponent: ");
                    num1 = sc.nextDouble();
                    num2 = sc.nextDouble();
                    System.out.println("Result: " + power(num1, num2));
                    break;
                case 6:
                    System.out.print("Enter a number: ");
                    num1 = sc.nextDouble();
                    System.out.println("Result: " + squareRoot(num1));
                    break;
                case 7:
                    System.out.print("Enter a number: ");
                    int n = sc.nextInt();
                    resultFact = factorial(n);
                    if (resultFact != -1) {
                        System.out.println("Result: " + resultFact);
                    }
                    break;
                case 8:
                    running = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
