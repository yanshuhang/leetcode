import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class LRUNode {
        int key;
        int value;
        LRUNode prev;
        LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final Map<Integer, LRUNode> cache = new HashMap<>();
    private int size;
    private final int capacity;
    private final LRUNode head;
    private final LRUNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
    }

    // 访问过节点就放到双链表的头部
    public int get(int key) {
        LRUNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    // 添加节点: 如果已存在修改value,然后将其移动到双链表的头部
    // 如果未存在: 创建节点加入map中,放到双链表的头部
    // 如果size大于capacity,移除双链表的尾部节点,并将该节点从map中删除
    public void put(int key, int value) {
        LRUNode node = cache.get(key);
        if (node == null) {
            LRUNode newNode = new LRUNode(key, value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                LRUNode tail = removeTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    private void addToHead(LRUNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void moveToHead(LRUNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LRUNode removeTail() {
        LRUNode ans = tail.prev;
        removeNode(ans);
        return ans;
    }
}
