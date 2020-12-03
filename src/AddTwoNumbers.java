public class AddTwoNumbers {
    public static ListNode solution(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        boolean flag = false;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (flag) {
                sum += 1;
            }
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            flag = sum >= 10;
        }
        if (flag) {
            tail.next = new ListNode(1);
        }
        return head;
    }
}
