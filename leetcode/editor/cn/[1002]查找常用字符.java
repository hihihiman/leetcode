//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 79 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] A) {
        if (A.length < 2) {
            return null;
        }
        int[] hash = new int[26];
        boolean firstFlag = true;
        for (String str:A){
            char[] chars = str.toCharArray();
            if (firstFlag){
                for (char item:chars){
                    hash[item-97]++;
                }
                firstFlag = false;
            }else {
                int[] tmpHash = new int[26];
                for (char item:chars){
                    tmpHash[item-97]++;
                }
                for (int i = 0; i < hash.length;++i) {
                    if (hash[i]>tmpHash[i]){
                        hash[i] = tmpHash[i];
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < hash.length; i++) {
            if (hash[i]!=0){
                String tmp = String.valueOf((char)(i+97));
                for (int j = 0; j < hash[i]; j++) {
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
