import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Task2 {

    static <T> void enqueue(LinkedList<T> queue, T element) {
        queue.addLast(element);
    }

    static <T> T dequeue(LinkedList<T> queue) throws NoSuchElementException {
        T result = queue.getFirst();
        queue.removeFirst();
        return result;
    }

    static <T> T first(LinkedList<T> queue) {
        return queue.getFirst();
    }

    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print("Очередь в начале: ");
        System.out.println(queue);
        enqueue(queue, 1);
        System.out.print("Очередь после добавления первого числа: ");
        System.out.println(queue);
        enqueue(queue, 2);
        System.out.print("Очередь после добавления второго числа: ");
        System.out.println(queue);
        enqueue(queue, 3);
        System.out.print("Очередь после добавления третьего числа: ");
        System.out.println(queue);
        System.out.print("Первый элемент очереди с удалением его из очереди: ");
        System.out.println(dequeue(queue));
        System.out.print("Очередь после удаления первого элемента: ");
        System.out.println(queue);
        System.out.print("Новый первый элемент очереди без удаления его из очереди: ");
        System.out.println(first(queue));
        System.out.print("Очередь в конце: ");
        System.out.println(queue);
    }
}
