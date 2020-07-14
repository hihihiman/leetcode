//给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 输入： A = "ab", B = "ba"
//输出： true
// 
//
// 示例 2： 
//
// 输入： A = "ab", B = "ab"
//输出： false
// 
//
// 示例 3: 
//
// 输入： A = "aa", B = "aa"
//输出： true
// 
//
// 示例 4： 
//
// 输入： A = "aaaaaaabc", B = "aaaaaaacb"
//输出： true
// 
//
// 示例 5： 
//
// 输入： A = "", B = "aa"
//输出： false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 20000 
// 0 <= B.length <= 20000 
// A 和 B 仅由小写字母构成。 
// 
// Related Topics 字符串 
// 👍 99 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] charsA = A.toCharArray();
        boolean isFirst = true;
        boolean isSecond = false;
        int indexFirst = 0;
        for (int i = 0; i < charsA.length; i++) {
            if (charsA[i] != B.charAt(i)) {
                if (isFirst) {
                    indexFirst = i;
                    isFirst = false;
                }else {
                    char temp = charsA[indexFirst];
                    charsA[indexFirst] = charsA[i];
                    charsA[i] = temp;
                    isSecond = true;
                    break;
                }
            }
        }


        return B.equals(new String(charsA));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
