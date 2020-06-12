//请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。 
//
// 
//
// 举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。 
//
// 如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。 
//
// 如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。 
//
// 
//
// 提示： 
//
// 
// 给定的两颗树可能会有 1 到 200 个结点。 
// 给定的两颗树上的值介于 0 到 200 之间。 
// 
// Related Topics 树 深度优先搜索


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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1= new ArrayList<>();
        List<Integer> list2= new ArrayList<>();
        help(root1,list1);
        help(root2,list2);
        return list1.equals(list2);
    }

    private void help(TreeNode node, List<Integer> list) {
        if (node==null){
            return;
        }
        if (node.left==null&&node.right==null){
            list.add(node.val);
            return;
        }
        help(node.left,list);
        help(node.right,list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
