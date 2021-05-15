import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class MyQueue {
    // instance 接受push的元素，pop时将instack的元素全部放入outstack中，实现队列的顺序，然后pop从outstack取元素
    private final Deque<Integer> inStack;
    private final Deque<Integer> outStack;
    public MyQueue() {
        inStack = new ArrayDeque<>();
        outStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.pop();
    }

    private void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }

    public int peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        Integer integer = outStack.peek();
        if (integer == null) {
            throw new NoSuchElementException();
        }
        return integer;
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
