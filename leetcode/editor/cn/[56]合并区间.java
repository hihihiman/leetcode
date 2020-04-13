//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组




//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] entry1, int[] entry2){
                return Integer.compare(entry1[0], entry2[0]);
            }
        });
        ArrayList<int[]> out = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (isOverlap(current, intervals[i])) {
                current = merge(current, intervals[i]);
            } else {
                out.add(current);
                current = intervals[i];
            }
        }
        out.add(current);
        int[][] oa = new int[out.size()][2];
        for (int i = 0; i < out.size(); i++) {
            oa[i] = out.get(i);
        }
        return oa;
    }

    private boolean isOverlap(int[] a, int[] b) {
        //判断a的右区间是否小于b的左区间
        return a[1] >= b[0] ? true : false;
    }

    private int[] merge(int[] a, int[] b) {
        //合并a，b区间
        int[] out = new int[2];
        out[0] = Math.min(a[0], b[0]);
        out[1] = Math.max(a[1], b[1]);
        return out;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
