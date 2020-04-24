//给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。 
//
// 示例 1: 
//
// 输入: nums = [1, 5, 1, 1, 6, 4]
//输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6] 
//
// 示例 2: 
//
// 输入: nums = [1, 3, 2, 2, 3, 1]
//输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2] 
//
// 说明: 
//你可以假设所有输入都会得到有效的结果。 
//
// 进阶: 
//你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？ 
// Related Topics 排序


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void wiggleSort(int[] nums) {
        int medium = findMedium(nums, 0, nums.length - 1, (nums.length + 1) >> 1);
        int s = 0, t = nums.length - 1 , mid_index = (nums.length + 1) >> 1;
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < medium)
                temp[s++] = nums[i];
            else if (nums[i] > medium)
                temp[t--] = nums[i];
        }

        while (s < mid_index) temp[s++] = medium;
        while (t >= mid_index) temp[t--] = medium;

        t = nums.length;
        for (int i = 0; i < nums.length; i++)
            nums[i] = (i & 1) == 0 ? temp[--s] : temp[--t];
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    private int findMedium(int[] nums,int left,int right,int k){
        if(left>=right) return nums[right];
        int i = partition(nums,left,right);
        int cnt = i-left+1;

        if (cnt == k) return nums[i];
        return cnt > k ? findMedium(nums, left, i - 1, k) : findMedium(nums, i + 1, right, k - cnt);
    }
    private int partition(int[] nums,int left,int right){
        int val = nums[left];
        int i = left,j=right;
        while (true){
            while (++i<right&&nums[i]<val);
            while (--j>left&&nums[j]>val);
            if (i>=j)break;
            swap(nums,i,j);
        }
        swap(nums,left,j);
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
