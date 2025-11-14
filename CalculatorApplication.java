import java.util.Scanner;

class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Error: Cannot divide by zero!");
        }
        return (double) a / b;
    }
}

public class CalculatorApplication {

    private static final Scanner sc = new Scanner(System.in);  
    private static final Calculator calculator = new Calculator();

    public static void performAddition() {
        System.out.println("\n--- Addition ---");
        System.out.println("1. Add two integers");
        System.out.println("2. Add two doubles");
        System.out.println("3. Add three integers");
        System.out.print("Choose addition type: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter first integer: ");
                int a1 = sc.nextInt();
                System.out.print("Enter second integer: ");
                int b1 = sc.nextInt();
                System.out.println("Result: " + calculator.add(a1, b1));
            }

            case 2 -> {
                System.out.print("Enter first double: ");
                double a2 = sc.nextDouble();
                System.out.print("Enter second double: ");
                double b2 = sc.nextDouble();
                System.out.println("Result: " + calculator.add(a2, b2));
            }

            case 3 -> {
                System.out.print("Enter first integer: ");
                int x = sc.nextInt();
                System.out.print("Enter second integer: ");
                int y = sc.nextInt();
                System.out.print("Enter third integer: ");
                int z = sc.nextInt();
                System.out.println("Result: " + calculator.add(x, y, z));
            }

            default -> System.out.println("Invalid choice!");
        }
    }

    public static void performSubtraction() {
        System.out.println("\n--- Subtraction ---");
        System.out.print("Enter first integer: ");
        int a = sc.nextInt();
        System.out.print("Enter second integer: ");
        int b = sc.nextInt();
        System.out.println("Result: " + calculator.subtract(a, b));
    }

    public static void performMultiplication() {
        System.out.println("\n--- Multiplication ---");
        System.out.print("Enter first number: ");
        double a = sc.nextDouble();
        System.out.print("Enter second number: ");
        double b = sc.nextDouble();
        System.out.println("Result: " + calculator.multiply(a, b));
    }

    public static void performDivision() {
        System.out.println("\n--- Division ---");
        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        try {
            double result = calculator.divide(a, b);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void mainMenu() {
        int choice;

        do {
            System.out.println("\n=== Calculator Application ===");
            System.out.println("1. Add Numbers");
            System.out.println("2. Subtract Numbers");
            System.out.println("3. Multiply Numbers");
            System.out.println("4. Divide Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number from 1 to 5.");
                sc.next();
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> performAddition();
                case 2 -> performSubtraction();
                case 3 -> performMultiplication();
                case 4 -> performDivision();
                case 5 -> System.out.println("Thank you for using the Calculator!");
                default -> System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}
