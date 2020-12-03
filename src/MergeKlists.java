public class MergeKlists {
    public static ListNode solution(ListNode[] listNodes) {
        ListNode ans = null;
        for (ListNode listNode : listNodes) {
            ans = MergeTwoLists.solution(ans, listNode);
        }
        return ans;
    }

    public static ListNode solution1(ListNode[] listNodes) {
        if (listNodes == null || listNodes.length == 0) {
            return null;
        }
        int len = listNodes.length;
        int left = 0;
        int right = len - 1;
        for (int i = 0; i < len-1; i++) {
            listNodes[left] = MergeTwoLists.solution(listNodes[left], listNodes[right]);
            left++;
            right--;
            if (left >= right) {
                left = 0;
            }
        }
        return listNodes[0];

    }
}
