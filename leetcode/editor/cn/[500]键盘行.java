//给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。 
//
// 
//
// 
//
// 
//
// 示例： 
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
//输出: ["Alaska", "Dad"]
// 
//
// 
//
// 注意： 
//
// 
// 你可以重复使用键盘上同一字符。 
// 你可以假设输入的字符串将只包含字母。 
// Related Topics 哈希表 
// 👍 99 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        String[] rec = new String[]{"qwertyuiop","asdfghjkl","zxcvbnm"};
        ArrayList<String> list = new ArrayList<>();
        for(String str:words){
            for (int i = 0; i < 3; i++) {
                boolean flag = true;
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    //转换小写
                    if (c>='A'&&c<='Z'){
                        c = (char)(c+32);
                    }
                    if (rec[i].indexOf(c)==-1){
                        flag= false;
                        break;
                    }
                }
                if (flag){
                    list.add(str);
                    break;
                }
            }
        }
        return list.toArray(new String[]{});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
