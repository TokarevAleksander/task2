import java.util.Scanner;

public class task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Выберите действие:");
        System.out.println("1. Выполнить арифметическую операцию");
        System.out.println("2. Выполнить операцию с массивом слов");
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                performArithmeticOperation(scanner);
                break;
            case 2:
                performArrayOperation(scanner);
                break;
            default:
                System.out.println("Неверный выбор!");
        }

        scanner.close();
    }

    public static void performArithmeticOperation(Scanner scanner) {
        
        System.out.print("Выберите операцию (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        
        System.out.print("Введите первое число: ");
        double num1 = parseDouble(scanner.next());

        
        System.out.print("Введите второе число: ");
        double num2 = parseDouble(scanner.next());

        double result = 0;

        // Выполнение арефмет. операций
        switch (operator) {
            case '+':
                result = add(num1, num2);
                break;
            case '-':
                result = subtract(num1, num2);
                break;
            case '*':
                result = multiply(num1, num2);
                break;
            case '/':
                try {
                    result = divide(num1, num2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
                break;
            default:
                System.out.println("Неверная операция!");
                return;
        }

        
        System.out.println("Результат: " + result);
    }

    public static void performArrayOperation(Scanner scanner) {
        
        System.out.print("Введите размерность массива слов: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // очистка буфера 

        
        String[] wordsArray = new String[size];

        // Запрос слов от пользователя и заполнение массива
        for (int i = 0; i < size; i++) {
            System.out.print("Введите слово " + (i + 1) + ": ");
            wordsArray[i] = scanner.nextLine();
        }

        
        String maxWord = findMax(wordsArray);

        
        System.out.println("Самое длинное слово в массиве: " + maxWord);
    }

    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Деление на ноль!");
        }
        return num1 / num2;
    }

    public static String findMax(String[] words) {
        String maxWord = words[0];
        for (String word : words) {
            if (word.length() > maxWord.length()) {
                maxWord = word;
            }
        }
        return maxWord;
    }

    private static double parseDouble(String str) {
        str = str.replace(",", ".");
        return Double.parseDouble(str);
    }
}
