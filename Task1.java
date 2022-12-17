import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {

    static <T> LinkedList<T> reversed(LinkedList<T> original) {
        LinkedList<T> reversed = new LinkedList<>();
        for (int i = original.size() - 1; i > -1; i--) {
            reversed.add(original.get(i));
        }
        return reversed;
    }

    static int getListLength(Scanner in) {
        int result;
        while (true) {
            System.out.print("Введите размер списка: ");
            while (!in.hasNextInt()) {
                System.out.print("Вы ввели не целое число. Попробуйте снова: ");
                in.nextLine();
            }
            result = in.nextInt();
            if (result >= 0) {
                break;
            }
            System.out.println("Размер списка должен быть больше или равен нулю.");
        }
        return result;
    }

    static LinkedList<Integer> randomLinkedList(int size, int minValue, int maxValue) {
        LinkedList<Integer> result = new LinkedList<>();
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        for (int i = 0; i < size; i++) {
            result.add(rnd.nextInt(minValue, maxValue + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = getListLength(in);
        in.close();
        LinkedList<Integer> list = randomLinkedList(size, 0, 10);
        System.out.println(list);
        LinkedList<Integer> reversedList = reversed(list);
        System.out.println(reversedList);
        System.out.println(list);
    }
}
