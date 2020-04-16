//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        return ans;
    }

    private void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorderTraversalHelper(root.left, ans);
        postorderTraversalHelper(root.right, ans);
        ans.add(root.val);

    }
}
//leetcode submit region end(Prohibit modification and deletion)
