//3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。 
//
// 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。 
//
// 
//
// 示例： 
//
// 输入: [[4,3,8,4],
//      [9,5,1,9],
//      [2,7,6,2]]
//输出: 1
//解释: 
//下面的子矩阵是一个 3 x 3 的幻方：
//438
//951
//276
//
//而这一个不是：
//384
//519
//762
//
//总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
// 
//
// 提示: 
//
// 
// 1 <= grid.length <= 10 
// 1 <= grid[0].length <= 10 
// 0 <= grid[i][j] <= 15 
// 
// Related Topics 数组 
// 👍 35 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i + 2 < n; i++) {
            for (int j = 0; j + 2 < m; j++) {
                res+=judge(i,j,grid);
            }
        }
        return res;
    }

    private int judge(int i, int j, int[][] grid) {
        //判断是否是唯一的1-9数字
        int[] a =new int[10];
        for (int k = 0; k < i+3; k++) {
            for (int l = 0; l < j+3; l++) {
                if (grid[k][l]>=10||grid[k][l]<=0) {
                    return 0;
                }
                a[grid[k][l]]++;
                if (a[grid[k][l]]>1){
                    return 0;
                }
            }
        }
        //判断每一行
        int sum = -1,tmp=0;
        for (int k = i; k < i+3; k++) {
            tmp = 0;
            for (int l = j; l < j + 3; l++) {
                tmp+=grid[k][l];
            }
            if (sum==-1) {
                sum=tmp;
            }else if (sum!=tmp){
                return 0;
            }
        }
        //判断每一列
        for (int k = j; k < j+3 ; k++) {
            tmp=0;
            for (int l = i; l <i+3 ; l++) {
                tmp+=grid[k][l];
            }
            if (sum!=tmp){
                return 0;
            }
        }
        //主对角线
        tmp = grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        if(sum!=tmp) {
            return 0;
        }
        //副对角线
        tmp = grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];
        if(sum!=tmp) {
            return 0;
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
