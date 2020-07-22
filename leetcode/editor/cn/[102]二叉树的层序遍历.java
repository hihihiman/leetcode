//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 567 👎 0

import define.TreeNode;

import java.util.ArrayList;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        dfs(1,root,res);
        return res;
    }

    private void dfs(int index, TreeNode root, List<List<Integer>> res) {
        if (res.size()<index){
            res.add(new ArrayList<>());
        }
            res.get(index-1).add(root.val);
        if (root.left!=null){
            dfs(index+1,root.left,res);
        }
        if (root.right!=null){
            dfs(index+1,root.right,res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
