//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计


//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {

    //左队列最大值优先
    PriorityQueue<Integer> smallerQueueWithBigTop = new PriorityQueue<>((a,b)->b-a);
    //右队列最小值优先
    PriorityQueue<Integer> biggerQueueWithSmallTop = new PriorityQueue<>((a,b)->a-b);
    double median =0;

    /** initialize your data structure here. */
    public MedianFinder() {

    }
    
    public void addNum(int num) {
        int smallerQueueSize = smallerQueueWithBigTop.size();
        int biggerQueueSize = biggerQueueWithSmallTop.size();
        if (smallerQueueSize==biggerQueueSize){
            //偶数情况
            if (smallerQueueSize==0){
                //要变成奇数，约定小的那一半多一个
                smallerQueueWithBigTop.add(num);
                return;
            }
            if (num<=biggerQueueWithSmallTop.peek()){
                //加到小的那一半
                smallerQueueWithBigTop.add(num);
            }else {
                //虽然属于大的那一半，但还是要保持小的那一半size更大
                smallerQueueWithBigTop.add(biggerQueueWithSmallTop.poll());
                biggerQueueWithSmallTop.add(num);
            }
        }else {
            if (num>=smallerQueueWithBigTop.peek()){
                //比小半大，直接加到大半。
                biggerQueueWithSmallTop.add(num);
            }else {
                //要加到小半，提前把小半的一个给大半
                biggerQueueWithSmallTop.add(smallerQueueWithBigTop.poll());
                smallerQueueWithBigTop.add(num);
            }
        }
    }
    
    public double findMedian() {
        if (smallerQueueWithBigTop.size()>biggerQueueWithSmallTop.size()){
            //奇数情况
            return smallerQueueWithBigTop.peek();
        }else {
            return 0.5*smallerQueueWithBigTop.peek()+0.5*biggerQueueWithSmallTop.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
