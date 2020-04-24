//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        Integer[] n = new Integer[nums.length];
        for (int i=0;i<nums.length;i++){
            n[i]=nums[i];
        }
        Arrays.sort(n,new Comparator<Integer>(){
            @Override
            public int compare(Integer n1,Integer n2){
                String s1 = n1+ "" + n2;
                String s2 = n2 + "" + n1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            sb.append(n[i]);
        }
        String res = sb.toString();
        return res.charAt(0) == '0'?"0":res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
