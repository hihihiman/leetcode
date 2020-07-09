//集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重
//复。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,2,4]
//输出: [2,3]
// 
//
// 注意: 
//
// 
// 给定数组的长度范围是 [2, 10000]。 
// 给定的数组是无序的。 
// 
// Related Topics 哈希表 数学 
// 👍 98 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
        HashMap<Integer,Integer > map = new HashMap<>();
        for (int i:nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (Map.Entry entry:map.entrySet()){
            max = Math.max(max,(int)entry.getKey());
            if (entry.getValue().equals(2)){
                res[0] = (int)entry.getKey();
            }
            int temp = (int) entry.getKey() - 1;
            if (!map.containsKey(temp)&&temp>0){
                min= Math.min(min,temp);
                res[1] =min;
            }
        }
        if (res[1]==0){
            res[1]=max+1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
