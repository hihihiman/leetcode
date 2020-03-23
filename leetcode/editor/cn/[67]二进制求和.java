//给定两个二进制字符串，返回他们的和（用二进制表示）。 
//
// 输入为非空字符串且只包含数字 1 和 0。 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
// Related Topics 数学 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i>=0||j>=0){
            //48是'0'的ASCII码
            int num1 = i >=0? a.charAt(i--)-'0':0;
            int num2 = j >=0? b.charAt(j--)-48:0;
            int sum = num1+num2+carry;
            carry=0;
            if (sum>=2){
                sum=sum%2;
                carry=1;
            }
            ans.append(sum);
        }
        ans = carry==1?ans.append(1):ans;
        return  ans.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
