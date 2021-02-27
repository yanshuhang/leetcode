import java.util.ArrayList;

public class BinarySearchTreeIterator {

    ArrayList<Integer> list;
    int index;

    public BinarySearchTreeIterator(TreeNode root) {
        // 中序遍历将节点存储在数组中
        list = new ArrayList<>();
        index = -1;
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return list.get(++index);
    }

    public boolean hasNext() {
        return index < list.size() - 1;
    }
}
