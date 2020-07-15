//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 示例 1: 
//
// 输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 说明： 
//
// 
// num1 和 num2 的长度小于110。 
// num1 和 num2 只包含数字 0-9。 
// num1 和 num2 均不以零开头，除非是数字 0 本身。 
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。 
// 
// Related Topics 数学 字符串 
// 👍 384 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] data = new int[len1+len2];
        for (int i = len1-1; i >=0; --i) {
            for (int j = len2-1; j >=0 ; --j) {
                int tempMulti = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int high = i+j;
                int low = high+1;
                int sum = data[low]+tempMulti;
                data[high]+=sum/10;
                data[low]=sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len1 + len2; i++) {
            if (data[i]==0&&sb.length()==0){
                continue;
            }else {
                sb.append(data[i]);
            }
        }
        if (sb.length()==0){
            return "0";
        }else {
            return sb.toString();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
