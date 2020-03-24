//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
      int majority = 0;
      int n = nums.length;
      for (int i =0,mask = 1;i<32;i++,mask<<=1){
          int bits = 0;
          //记录这一位的1的数量
          for (int j = 0;j<n;j++){
              if ((mask&nums[j])==mask){
                  bits++;
              }
          }
          //1超过半数
          if (bits>n/2){
              majority|=mask;
          }
      }
      return majority;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
