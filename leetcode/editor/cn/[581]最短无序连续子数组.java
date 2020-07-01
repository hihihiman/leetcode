//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums==null||nums.length<2){
            return 0;
        }
        int len = nums.length;
        int temp = 0;
        int left = -1,right=-1;
        int max = nums[0],min = nums[len-1];
        for (int i = 1;i<len;i++){
            if (max>nums[i]){
                right = i;
            }else {
                max = nums[i];
            }
            temp = len -i -1;
            if (min<nums[temp]){
                left = temp;
            }else {
                min = nums[temp];
            }
        }
        return right>left?right - left+1:0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
