//给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。 
//
// 案例 1: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 9
//
//输出: True
// 
//
// 
//
// 案例 2: 
//
// 
//输入: 
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//Target = 28
//
//输出: False
// 
//
// 
// Related Topics 树

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

    private List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root==null){
            return false;
        }
        inOrder(root);
        int i =0;
        int j = list.size()-1;
        while (i<j){
            int sum = list.get(i)+list.get(j);
            if (sum==k){
                return true;
            }else if (sum<k){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode node) {
        if (node==null){
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
