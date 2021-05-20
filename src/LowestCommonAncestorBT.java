public class LowestCommonAncestorBT {
    private TreeNode ans;
    public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 当前节点
        boolean isCurrentNode = root == q || root == p;
        // 左子树
        boolean inLeft = dfs(root.left, p, q);
        // 右子树
        boolean inRight = dfs(root.right, p, q);
        //最近公共祖先必须满足两个条件之一，且最多只有一个node满足条件：
        // 1.p和q分别在其左子树和右子树：inleft && inRight == true
        // 2.p或q是当前节点，另一个在左子树或右子树：isCurrent && (inLeft || inRight) == true
        if ((inLeft && inRight) || (isCurrentNode && (inLeft || inRight))) {
            ans = root;
        }
        // 将p和q节点的情况传递到父节点
        return inLeft || inRight || isCurrentNode;
    }

    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        //最近公共祖先必须满足两个条件之一，且最多只有一个node满足条件：
        // 1.p和q分别在其左子树和右子树：inleft && inRight == true
        // 2.p或q是当前节点，另一个在左子树或右子树：isCurrent && (inLeft || inRight) == true

        // 向下递归到null或者找到其中一个节点不再向下递归，因为公共父节点只可能是该节点或者往上的节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 如果left和right不为null，说明p和q一个在左子树一个在右子树，满足条件1，返回root，再往上传递也不可能满足条件了
        // left和right为null，说明p和q都不在子树中，返回null
        // 如果left和right一个为null，说明找到了一个节点，向上返回直到找到另一个满足条件1，或者另一个在其子树上，由于没有继续向下递归，所以没找到，此时满足条件2
        TreeNode left = solution1(root.left, p, q);
        TreeNode right = solution1(root.right, p ,q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
