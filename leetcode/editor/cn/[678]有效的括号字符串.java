//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
        int low=0,high=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                low++;
                high++;
            }else if (s.charAt(i)==')'){
                if (low>0){
                    low--;
                }
                high--;
            }else {
                //星号在high时作为右括号
                if (low>0){
                    low--;
                }
                high++;
            }
            if (high<0){
                //单独右括号的情况
                return false;
            }
        }
        //检查是否有多余的左括号
        return low==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
