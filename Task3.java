import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task3 {

    static double enterDouble(String invitation, Scanner in) {
        double result;
        System.out.print(invitation);
        while (!in.hasNextDouble()) {
            in.nextLine();
            System.out.println("Вы ввели не число. Попробуйте снова.");
            System.out.print(invitation);
        }
        result = in.nextDouble();
        in.nextLine();
        return result;
    }

    static char enterSign(Scanner in) {
        char result;
        String test;
        while (true) {
            System.out.print("Введите знак операции: ");
            test = in.nextLine();
            if (test.equals("+") || test.equals("-") || test.equals("*") || test.equals("/")) {
                result = test.charAt(0);
                break;
            }
            System.out.println("Вы ввели что-то не то. Попробуйте снова.");
        }
        return result;
    }

    static double calc(double first, double second, char operator) {
        if (operator == '+') return first + second;
        if (operator == '-') return first - second;
        if (operator == '*') return first * second;
        return first / second;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Logger log = Logger.getLogger(Task3.class.getName());
        try {
            FileHandler fh = new FileHandler("log3.txt");
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
            log.addHandler(fh);
            double first = 0, second;
            boolean undo = false;
            boolean stop = false;
            char sign;
            String input;
            Stack<String> results = new Stack<>();
            while (true) {
                while (true) {
                    System.out.print("Введите первое число или \"назад\", чтобы вывести последнюю операцию, " +
                            "или \"выход\", чтобы закончить работу программы: ");
                    input = in.nextLine();
                    if (input.equals("назад")) {
                        undo = true;
                        break;
                    }
                    if (input.equals("выход")) {
                        stop = true;
                        break;
                    }
                    try {
                        first = Double.parseDouble(input);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Вы ввели не число и не \"назад\".");
                    }
                }
                if (stop) {
                    break;
                }
                if (!undo) {
                    log.info(String.format("Первое число: %f", first));
                    second = enterDouble("Введите второе число: ", in);
                    log.info(String.format("Второе число: %f", second));
                    if (second == 0) {
                        undo = true;
                    }
                    sign = enterSign(in);
                    log.info(String.format("Знак: %c", sign));
                    double mathResult = calc(first, second, sign);
                    String result = String.format("%f %c %f = %f", first, sign, second, mathResult);
                    System.out.println(result);
                    log.info(result);
                    results.push(result);
                } else {
                    if (!results.empty()) {
                        System.out.println(results.pop());
                    } else {
                        System.out.println("Нет операции, которую можно отменить.");
                    }
                    undo = false;
                }
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка:");
            e.printStackTrace();
        }
        in.close();
    }
}
