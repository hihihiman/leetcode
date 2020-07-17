//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 207 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        int row = 0,col=0;
        for (int i = 1; i <= n * n; i++) {
            matrix[row][col] = i;
            visited[row][col] = true;
            int nextRow = row+directions[directionIndex][0];
            int nextCol = col+directions[directionIndex][1];
            if (nextRow<0||nextCol<0||nextRow>=n||nextCol>=n||visited[nextRow][nextCol]){
                directionIndex = (directionIndex+1)%4;
            }
            row+=directions[directionIndex][0];
            col+=directions[directionIndex][1];
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
