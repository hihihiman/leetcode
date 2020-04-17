//编写一个程序，找出第 n 个丑数。 
//
// 丑数就是只包含质因数 2, 3, 5 的正整数。 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
// Related Topics 堆 数学 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        int count = 0;
        long result =1;
        set.add(result);
        while (count<n){
            result = set.pollFirst();
            count++;
            set.add(result*2);
            set.add(result*3);
            set.add(result*5);
        }
        return (int)result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
