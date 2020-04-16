//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if (rows==0){
            return false;
        }
        int cols = board[0].length;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (existRecursive(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean existRecursive(char[][] board,int row,int col,String word,int index){
        if (row<0||row>=board.length||col<0||col>=board[0].length){
            return false;
        }
        if (board[row][col]!=word.charAt(index)){
            return false;
        }
        if (index ==word.length()-1){
            return true;
        }
        //标记访问
        board[row][col] ^= 128;
        boolean up = existRecursive(board,row-1,col,word,index+1);
        if (up){
            return true;
        }
        boolean down = existRecursive(board,row+1,col,word,index+1);
        if (down){
            return true;
        }
        boolean left = existRecursive(board,row,col-1,word,index+1);
        if (left){
            return true;
        }
        boolean right = existRecursive(board,row,col+1,word,index+1);
        if (right){
            return true;
        }
        board[row][col] ^= 128;
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
