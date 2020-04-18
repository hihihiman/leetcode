//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例: 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(a-b));
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                pq.add(matrix[i][j]);
            }
        }
        int ans =0;
        for (int i=0;i<k;i++){
            ans = pq.poll();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
