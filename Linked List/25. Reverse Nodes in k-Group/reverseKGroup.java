/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        for(ListNode i = head; i != null;){
            n++;
            i = i.next;
        }
        //set a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //reverse node in k-group
        for(ListNode pre = dummy, tail = head; n >= k; n -= k){
            for(int i = 1; i < k; i++){
                ListNode next = tail.next.next;
                tail.next.next = pre.next;
                pre.next = tail.next;
                tail.next = next;
            }
            pre = tail;
            tail = tail.next;
        }
        return dummy.next;
    }
}
//idea: iterative linkedlist
//time: O(n)
//space:O(1)
//https://leetcode.com/problems/reverse-nodes-in-k-group/discuss/11423/Short-but-recursive-Java-code-with-comments
