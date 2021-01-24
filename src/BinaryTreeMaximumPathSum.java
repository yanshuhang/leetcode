public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int solution(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // 从node节点往下走的路径的最大值
    public int maxGain(TreeNode node) {
        // 如果到达底部返回0
        if (node == null) {
            return 0;
        }
        // 递归求解node左右节点的往下路径最大值
        int leftGain = Math.max(0,maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));
        // 求得最大值
        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);
        return node.val + Math.max(leftGain, rightGain);
    }
}
