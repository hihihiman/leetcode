//给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
//
// 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。 
//
// 山羊拉丁文的规则如下： 
//
// 
// 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。 
// 例如，单词"apple"变为"applema"。 
// 
// 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。 
// 例如，单词"goat"变为"oatgma"。 
// 
// 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。 
// 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。 
// 
//
// 返回将 S 转换为山羊拉丁文后的句子。 
//
// 示例 1: 
//
// 
//输入: "I speak Goat Latin"
//输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
// 
//
// 示例 2: 
//
// 
//输入: "The quick brown fox jumped over the lazy dog"
//输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaa
//aaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
// 
//
// 说明: 
//
// 
// S 中仅包含大小写字母和空格。单词间有且仅有一个空格。 
// 1 <= S.length <= 150。 
// 
// Related Topics 字符串 
// 👍 40 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toGoatLatin(String S) {
        String[] splits = S.split("\\s");
        String res = "";
        for (int i = 0; i < splits.length; i++) {
            res += handleWord(splits[i], i);
            if (i != splits.length - 1) {
                res += " ";
            }
        }
        return res;
    }

    private String handleWord(String word, int i) {
        String newWord = "";
        if (isVowel(word.charAt(0))) {
            newWord = word;
        } else {
            for (int j = 1; j < word.length(); j++) {
                newWord += word.charAt(j);
            }
            newWord += word.charAt(0);
        }
        newWord+="ma";
        for (int j = 0; j < i+1; j++) {
            newWord += "a";
        }
        return newWord;
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
                return true;
            case 'e':
                return true;
            case 'i':
                return true;
            case 'o':
                return true;
            case 'u':
                return true;
            case 'A':
                return true;
            case 'E':
                return true;
            case 'I':
                return true;
            case 'O':
                return true;
            case 'U':
                return true;
            default:return false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
