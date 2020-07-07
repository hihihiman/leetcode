//给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。 
//
// 请你找到并返回这个整数 
//
// 
//
// 示例： 
//
// 
//输入：arr = [1,2,2,6,6,6,6,7,10]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 0 <= arr[i] <= 10^5 
// 
// Related Topics 数组 
// 👍 25 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findSpecialInteger(int[] arr) {
        int temp =1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==arr[i-1]){
                temp++;
            }else {
                if (temp*4>arr.length){
                    return arr[i-1];
                }
                temp = 1;
            }
        }
        return arr[arr.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
