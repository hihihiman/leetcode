//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root,0,ans);
        return ans;
    }
    private void DFS(TreeNode root,int level,List<List<Integer>> ans){
        if(root ==null){
            return;
        }
        if (ans.size()<=level){
            ans.add(new ArrayList<>());
        }
        if ((level%2)==0){
            //偶数层，逆序，尾插
            ans.get(level).add(root.val);
        }else{
            //奇数层，顺序，头插
            ans.get(level).add(0,root.val);
        }
        DFS(root.left,level+1,ans);
        DFS(root.right,level+1,ans);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
