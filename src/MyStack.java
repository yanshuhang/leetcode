import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        while (n > 0) {
            queue.offer(queue.poll());
            n--;
        }
    }

    public int pop() {
        return Objects.requireNonNull(queue.poll());
    }

    public int top() {
        return Objects.requireNonNull(queue.peek());
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
