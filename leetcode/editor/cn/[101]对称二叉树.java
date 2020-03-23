//给定一个二叉树，检查它是否是镜像对称的。 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 说明: 
//
// 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root==null){
            return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }
    private boolean isSymmetricHelper(TreeNode left,TreeNode right){
        if (left==null && right != null||left!=null&&right==null){
            return false;
        }
        if (left !=null&&right!=null){
            if (left.val!=right.val){
                return false;
            }
            return isSymmetricHelper(left.left,right.right)&&isSymmetricHelper(left.right,right.left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
