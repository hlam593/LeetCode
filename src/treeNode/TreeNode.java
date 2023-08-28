package treeNode;

/**
 * @Description: Definition for a binary tree node.
 * @Auther: hlam
 * @Date: 2023/08/14
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    private static TreeNode createBinaryTree(int[] array, int index) {

        TreeNode treeNode = null;
        if (index < array.length) {
            treeNode = new TreeNode(array[index]);
            // 对于顺序存储的完全二叉树，如果某个节点的索引为index，其对应的左子树的索引为2*index+1，右子树为2*index+1
            treeNode.left = createBinaryTree(array, 2 * index + 1);
            treeNode.right = createBinaryTree(array, 2 * index + 2);
        }
        return treeNode;

    }

    private void showData(TreeNode node) {
        System.out.print(node);
    }

    // 递归遍历二叉树

    // 先序遍历（前序遍历）
    public void preOrder(TreeNode node) {
        if (node != null) {
            showData(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 中序遍历
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            showData(node);
            inOrder(node.right);
        }
    }
    // 后序遍历

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            showData(node);
        }
    }
}
