//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//
// 给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最小深度 2. 
// Related Topics 树 深度优先搜索 广度优先搜索


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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root==null){
            return 0;
        }
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for (int i=0;i<levelNum;i++){
                TreeNode curNode = queue.poll();
                if (curNode!=null){
                    if(curNode.left==null&&curNode.right==null){
                        return level;
                    }
                    if (curNode.left!=null){
                        queue.offer(curNode.left);
                    }
                    if (curNode.right!=null){
                        queue.offer(curNode.right);
                    }
                }
            }
            level++;
        }
        return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
