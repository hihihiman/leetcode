//给定两个字符串 A 和 B, 寻找重复叠加字符串A的最小次数，使得字符串B成为叠加后的字符串A的子串，如果不存在则返回 -1。 
//
// 举个例子，A = "abcd"，B = "cdabcdab"。 
//
// 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。 
//
//
// 注意: 
//
// A 与 B 字符串的长度在1和10000区间范围内。 
// Related Topics 字符串 
// 👍 91 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int maxLen = A.length() * 2 + B.length();
        String s = A;
        while(s.length() < maxLen && !s.contains(B)){
            s += A;
        }
        return s.contains(B) ? s.length() / A.length() : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
