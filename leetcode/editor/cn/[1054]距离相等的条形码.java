//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中两个相邻的条形码 不能 相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 输入：[1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 输入：[1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// 
// Related Topics 堆 排序


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < barcodes.length; i++) {
            int item = barcodes[i];
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        maxHeap.addAll(map.entrySet());
        Map.Entry<Integer,Integer> preciousEntry = null;
        int[] res = new int[barcodes.length];
        int i=0;
        while (!maxHeap.isEmpty()){
            Map.Entry<Integer,Integer> currentEntry = maxHeap.poll();
            res[i++] = currentEntry.getKey();
            currentEntry.setValue(currentEntry.getValue()-1);
            if (preciousEntry!=null&&preciousEntry.getValue()>0){
                maxHeap.add(preciousEntry);
            }
            preciousEntry = currentEntry;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
