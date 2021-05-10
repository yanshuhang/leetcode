import java.util.HashMap;

public class CountCompleteTreeNodes {
    public int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
            height++;
        }
        int low = 1 << height;
        int high = (1 << (height + 1)) - 1;
        while (low < high) {
            int mid = (low + high + 1) >>> 1;
            if (exits(root, height, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exits(TreeNode root, int height, int k) {
        int bits = 1 << (height - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }

    // 递归
    public int solution1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return solution1(root.left) + solution1(root.right) + 1;
    }

    public static void main(String[] args) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        for (int i = 0; i < 800 ; i++) {
            map.put(i, new TreeNode(i));
        }
        for (int i = 0; i < 800; i++) {
            TreeNode node = map.get(i);
            TreeNode left = map.get((i << 1) + 1);
            TreeNode right = map.get((i << 1) + 2);
            node.left = left;
            node.right = right;
        }
        TreeNode root = map.get(0);
        System.out.println(new CountCompleteTreeNodes().solution(root));
        System.out.println(new CountCompleteTreeNodes().solution1(root));
    }
}
