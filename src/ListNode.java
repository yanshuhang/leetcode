public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        ListNode node = this;
        while (true) {
            builder.append(node.val);
            node = node.next;
            if (node == null) {
                break;
            }
            builder.append(",");
        }
        builder.append("]");
        return builder.toString();
    }

    public static ListNode build(int... nums) {
        ListNode head = null;
        ListNode tail = null;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.build(1, 2, 3, 4, 5, 6, 7));
    }
}
