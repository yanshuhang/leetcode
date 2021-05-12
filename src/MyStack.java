import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return Objects.requireNonNull(queue1.poll());
    }

    public int top() {
        return Objects.requireNonNull(queue1.peek());
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
