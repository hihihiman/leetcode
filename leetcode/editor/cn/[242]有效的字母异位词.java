//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        for (int i=0;i<sArray.length;i++){
            int count = map.getOrDefault(sArray[i],0);
            map.put(sArray[i],count+1);
        }
        for (int i=0;i<tArray.length;i++){
            int count = map.getOrDefault(tArray[i],0);
            if (count==0){
                return false;
            }
            map.put(tArray[i],count-1);
        }
        for (int value:map.values()){
            if (value!=0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
