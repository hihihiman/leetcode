//给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1: 
//
// 输入: "bcabc"
//输出: "abc"
// 
//
// 示例 2: 
//
// 输入: "cbacdcbc"
//输出: "acdb" 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct
//-characters 相同 
// Related Topics 栈 贪心算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private final int CHAR_COUNT = 26;
    public String removeDuplicateLetters(String s) {
        if (s==null)throw new NullPointerException();
        if (s.length()<1)return s;
        int n = s.length();
        int[] count = new int[CHAR_COUNT];
        boolean[] visited = new boolean[CHAR_COUNT];
        for (int i=0;i<n;++i){
            //每个字母出现的次数
            ++count[s.charAt(i)-'a'];
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;++i){
            char c = s.charAt(i);
            --count[c-'a'];
            if (visited[c-'a']){
                continue;
            }
            while (sb.length()>0&&c<sb.charAt(sb.length()-1)&&count[sb.charAt(sb.length()-1)-'a']>0){
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);

            visited[c - 'a'] = true;
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
