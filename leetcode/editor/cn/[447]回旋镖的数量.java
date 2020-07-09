//给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺
//序）。 
//
// 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。 
//
// 示例: 
//
// 
//输入:
//[[0,0],[1,0],[2,0]]
//
//输出:
//2
//
//解释:
//两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
// Related Topics 哈希表 
// 👍 96 👎 0


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    break;
                }
                int dis = dis(points[i],points[j]);
                map.put(dis,map.getOrDefault(dis,0)+1);
            }
        }
        for (int k :map.values()){
            if (k>=2){
                count+=k*(k-1);
            }
        }
        return count;
    }

    private int dis(int[] pointA, int[] pointB) {
        int x1 = pointA[0];
        int y1 = pointA[1];
        int x2 = pointB[0];
        int y2 = pointB[1];
        return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
