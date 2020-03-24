//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final char[] charMap = new char[256];
    static{
        for (int i=0;i<10;i++){
            charMap[i+'0']=(char)(1+i);
        }
        for (int i=0;i<26;i++){
            charMap[i+'a']=charMap[i+'A']=(char)(11+i);
        }
    }
    public boolean isPalindrome(String s) {
        char[] pChars = s.toCharArray();
        int start = 0,end = pChars.length-1;
        char cS,cE;
        while (start<end){
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if (cS!=0&&cE!=0){
                if (cS!=cE){
                    return false;
                }
                start++;
                end--;
            }else {
                if (cS==0){
                    start++;
                }
                if (cE==0){
                    end--;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
