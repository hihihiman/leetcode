//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 深度优先搜索 数组

import define.TreeNode;

import java.util.HashMap;

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> mapIn = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mapIn.put(inorder[i], i);
        }
        return helper(mapIn, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(HashMap<Integer, Integer> mapIn, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int i = mapIn.get(postorder[pe]);
        root.left = helper(mapIn, is, i - 1, postorder, ps, ps - 1 + i - is);
        root.right = helper(mapIn, i + 1, ie, postorder, ps + i - is, pe - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
