import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    // 提前next，值缓存在current中
    private Integer current;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    public Integer peek() {
        if (current == null) {
            current = iterator.next();
        }
        return current;
    }

    @Override
    public boolean hasNext() {
        return current != null || iterator.hasNext();
    }

    @Override
    public Integer next() {
        if (current != null) {
            Integer result = current;
            current = null;
            return result;
        }
        return iterator.next();
    }
}
