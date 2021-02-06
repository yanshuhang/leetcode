import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class MinStack {
    // stack存储x值和压入前的min的差diff
    // 1. diff >= 0 说明min未改变, push之后min还是原值,top时通过diff可求出当前的x值,pop时不需修改min
    // 2. diff < 0 说明min值有改变, push之后min为x值,top时返回min即可,pop时通过diff修改min
    private final Deque<Long> stack;
    private int min;
    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push((long) x - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        Long diff = stack.pop();
        if (diff < 0) {
            min = (int) (min - diff);
        }
    }

    public int top() {
        Long diff = stack.peek();
        if (Objects.requireNonNull(diff) < 0) {
            return min;
        } else {
            return ((int) (min + diff));
        }
    }

    public int getMin() {
        return min;
    }
}
