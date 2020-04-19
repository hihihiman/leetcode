//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。 
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。 
//
// 示例 1: 
//
// 
//输入: S = "aab"
//输出: "aba"
// 
//
// 示例 2: 
//
// 
//输入: S = "aaab"
//输出: ""
// 
//
// 注意: 
//
// 
// S 只包含小写字母并且长度在[1, 500]区间内。 
// 
// Related Topics 堆 贪心算法 排序 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reorganizeString(String S) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i=0;i<S.length();i++){
            char c = S.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        //大顶堆
        Queue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        maxHeap.addAll(map.entrySet());

        Map.Entry<Character,Integer> preciousEntry = null;
        StringBuilder sb = new StringBuilder();
        if (maxHeap.peek().getValue()<=(S.length()+1)/2){
            while (!maxHeap.isEmpty()){
                Map.Entry<Character,Integer> currentEntry = maxHeap.poll();
                sb.append(currentEntry.getKey());
                currentEntry.setValue(currentEntry.getValue()-1);
                if (preciousEntry!=null&&preciousEntry.getValue()>0){
                    maxHeap.add(preciousEntry);
                }
                preciousEntry = currentEntry;
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
