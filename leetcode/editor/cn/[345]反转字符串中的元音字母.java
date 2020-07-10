//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串 
// 👍 99 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static boolean[] vowels=new boolean[123];     //第一处疑问，为什么要private和static修饰？
        static{
            vowels['a']=true;
            vowels['e']=true;
            vowels['i']=true;
            vowels['o']=true;
            vowels['u']=true;
            vowels['A']=true;
            vowels['E']=true;
            vowels['I']=true;
            vowels['O']=true;
            vowels['U']=true;
        }
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while (left<right){
            if (!vowels[chars[left]]){
                left++;
                continue;
            }
            if (!vowels[chars[right]]){
                right--;
                continue;
            }
            swap(chars,left,right);
            left++;
            right--;
        }
        return new String(chars);
    }

    private void   swap(char[] chars, int left, int right) {

        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
