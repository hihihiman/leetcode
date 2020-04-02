//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = 0,end = nums.length-1;
        int[] ans = {-1,-1};
        if (nums.length==0){
            return ans;
        }
        while (start<=end){
            int mid = (start + end)/2;
            if (target==nums[mid]){
                int n = mid >0?nums[mid-1]:Integer.MIN_VALUE;
                if (target>n||mid==0){
                    ans[0]=mid;
                    break;
                }
                end = mid -1;
            }else if (target<nums[mid]){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        start = 0;
        end = nums.length - 1;
        while (start<=end){
            int mid = (start + end)/2;
            if(target==nums[mid]){
                int n = mid <nums.length - 1 ? nums[mid+1]:Integer.MAX_VALUE;
                if (target < n || mid == nums.length - 1) {
                    ans[1] = mid;
                    break;
                }
                start = mid + 1;
            }else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
