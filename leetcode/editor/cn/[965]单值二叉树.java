//如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。 
//
// 只有给定的树是单值二叉树时，才返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[1,1,1,1,1,null,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//
// 输入：[2,2,2,5,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 给定树的节点数范围是 [1, 100]。 
// 每个节点的值都是整数，范围为 [0, 99] 。 
// 
// Related Topics 树


import define.TreeNode;
//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean flag = true;

    public boolean isUnivalTree(TreeNode root) {
        int temp = root.val;
        help(root, temp);
        return flag;
    }

    private void help(TreeNode root, int temp) {
        if (!flag) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.val != temp) {
            flag = false;
        }
        help(root.left, temp);
        help(root.right, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
