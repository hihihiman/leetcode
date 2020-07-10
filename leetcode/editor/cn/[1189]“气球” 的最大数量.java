//给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：text = "nlaebolko"
//输出：1
// 
//
// 示例 2： 
//
// 
//
// 输入：text = "loonbalxballpoon"
//输出：2
// 
//
// 示例 3： 
//
// 输入：text = "leetcode"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 10^4 
// text 全部由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 
// 👍 35 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfBalloons(String text) {
        //abnlloo
        final int numa = 1,numb = 1,numn=1,numl=2,numo=2;
        int[] chars = new int[26];
        for(char c:text.toCharArray()){
            chars[c-'a']++;
        }
        int count =chars['a'-'a']/numa;
        count = Math.min(count,chars['b'-'a']/numb);
        count = Math.min(count,chars['n'-'a']/numn);
        count = Math.min(count,chars['l'-'a']/numl);
        return Math.min(count,chars['o'-'a']/numo);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
