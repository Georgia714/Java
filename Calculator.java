import java.util.Scanner;

public class Calculator {

    //This functions asks a user for their first and last name, then prints out their full name.
    public static void inputName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String name = userInput.nextLine();
        System.out.println("Thanks. Now please enter your surname: ");
        String surname = userInput.nextLine();
        System.out.println("Your full name is: " + name + " " + surname);
    }
    //This function takes in a number from the user and triples it.
    public static void inputTriple() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        int number = userInput.nextInt() * 3;
        System.out.println("The number you entered is: " + number);
    }
    //This is a basic calculator function. It asks the user to enter two numbers and an operator and returns the result.
    public static void calculator() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        double number1 = userInput.nextInt();
        System.out.println("Please enter an operator: +, -, /, * or %");
        char operator = userInput.next().charAt(0);
        System.out.println("Please enter another number");
        double number2 = userInput.nextInt();
        double total;
        switch (operator) {
            case '+':
                total = number1 + number2;
                System.out.println("Total: " + total);
                break;
            case '-':
                total = number1 - number2;
                System.out.println("Total: " + total);
                break;
            case '/':
                total = number1 / number2;
                System.out.println("Total: " + total);
                break;
            case '*':
                total = number1 * number2;
                System.out.println("Total: " + total);
                break;
            case '%':
                total = number1 % number2;
                System.out.println("Total: " + total);
                break;
            default:
                System.out.println("You entered an invalid operator.");
        }

    }

    public static void main(String[] args) {
        inputName();
        inputTriple();
        calculator();
    }
}
