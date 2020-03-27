//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null||head.next==null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverseList(slow);
        while (newHead!=null){
            if (head.val!=newHead.val){
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    private ListNode reverseList(ListNode head){
        ListNode tail = null;
        while (head!=null){
            ListNode temp = head.next;
            head.next = tail;
            tail = head;
            head = temp;
        }
        return tail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
