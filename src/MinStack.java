import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> helper;

    public MinStack() {
        stack = new LinkedList<>();
        helper = new LinkedList<>();
        helper.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        helper.push(Math.min(helper.peek(), x));
    }

    public void pop() {
        stack.pop();
        helper.pop();
    }

    public int top() {
        return (stack.peek());
    }

    public int getMin() {
        return helper.peek();
    }
}
