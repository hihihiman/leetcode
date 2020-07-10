//你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。 
//
// 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。 
//
// 
//
// 示例 1： 
//
// 输入：name = "alex", typed = "aaleex"
//输出：true
//解释：'alex' 中的 'a' 和 'e' 被长按。
// 
//
// 示例 2： 
//
// 输入：name = "saeed", typed = "ssaaedd"
//输出：false
//解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
// 
//
// 示例 3： 
//
// 输入：name = "leelee", typed = "lleeelee"
//输出：true
// 
//
// 示例 4： 
//
// 输入：name = "laiden", typed = "laiden"
//输出：true
//解释：长按名字中的字符并不是必要的。
// 
//
// 
//
// 提示： 
//
// 
// name.length <= 1000 
// typed.length <= 1000 
// name 和 typed 的字符都是小写字母。 
// 
//
// 
//
// 
// Related Topics 双指针 字符串 
// 👍 74 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.length() * typed.length() == 0) {
            return false;
        }
        //首字母必须相等
        if(name.charAt(0) != typed.charAt(0)) {
            return false;
        }
        int i = 1, j = 1;
        //typed字符串当前元素，要么等于name当前元素，要么等于name元素前一个
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(name.charAt(i - 1) == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        //name字符串没有遍历完，必定为false
        if(i < name.length()) {
            return false;
        }
        //name遍历完， typed没有遍历完，那么typed后面的字符都要与name最后一个字符相等
        while(j < typed.length()){
            if(name.charAt(i - 1) != typed.charAt(j)) {
                return false;
            }
            j++;
        }
        //两个字符串都遍历完
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
