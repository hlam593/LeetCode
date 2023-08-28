package treeNode;

import org.junit.Test;

/**
 * @Description: 二叉树
 * @Auther: hlam
 * @Date: 2023/08/14
 */
public class Solution {

    @Test
    public void testMergeTree() {

    }

    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
     * 示例1:
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意:合并必须从两个树的根节点开始。
     * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
     * 输出：[3,4,5,5,4,null,7]
     * 输入：root1 = [1], root2 = [1,2]
     * 输出：[2,2]
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode ans = new TreeNode(root1.val + root2.val);
        ans.left = mergeTrees(root1.left, root2.left);
        ans.right = mergeTrees(root1.right, root2.right);
        return ans;
    }

}
