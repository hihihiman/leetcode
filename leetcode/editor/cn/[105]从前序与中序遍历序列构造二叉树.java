//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

import com.sun.source.tree.Tree;
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode build(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart > pre.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.val == in[i]) {
                index = i;
                break;
            }
        }
        root.left = build(pre, in, preStart + 1, inStart, index - 1);
        root.right = build(pre, in, preStart + 1 + index - inStart, index + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
