//给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 示例 1: 
//
// 
//输入: [1, 2, 2, 3, 1]
//输出: 2
//解释: 
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2: 
//
// 
//输入: [1,2,2,3,1,4,2]
//输出: 6
// 
//
// 注意: 
//
// 
// nums.length 在1到50,000区间范围内。 
// nums[i] 是一个在0到49,999范围内的整数。 
// 
// Related Topics 数组 
// 👍 143 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
        int maxCount = 1;
        ArrayList<Object> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            int temp = map.getOrDefault(n, 0) + 1;
            map.put(n, temp);
            maxCount = Math.max(maxCount, temp);
        }
        Set<Integer> set = map.keySet();
        int minDis = Integer.MAX_VALUE;
        for (int n : set) {
            int temp = Integer.MAX_VALUE;
            if (map.get(n) == maxCount) {
                int i = 0, j = nums.length - 1;
                while (nums[i] != n && i < j) {
                    i++;
                }
                while (nums[j] != n && i < j) {
                    j--;
                }
                temp = j - i + 1;
            }
            minDis = Math.min(minDis, temp);
        }
        return minDis;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
