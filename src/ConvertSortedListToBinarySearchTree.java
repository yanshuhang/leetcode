public class ConvertSortedListToBinarySearchTree {
    public TreeNode solution(ListNode head) {
        return build(head, null);
    }

    public TreeNode build(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(left, mid);
        root.right = build(mid.next, left);
        return root;
    }

    // 双指针快速找到中点
    public ListNode getMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
