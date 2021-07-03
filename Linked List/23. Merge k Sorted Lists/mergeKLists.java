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
    public ListNode mergeKLists(ListNode[] lists) {
        //conner case
        if(lists == null || lists.length == 0){
            return null;
        }
        //sort the node in list
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            cur.next = pq.poll();
            cur = cur.next;
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
}
//idea: minheap+linkedlist
// Time complexity : O(Nlogk) where k is the number of linked lists.
// The comparison cost will be reduced to O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1) time.
// There are N nodes in the final linked list.
//time:O(nlogk)
//space:O(n) + O(k), 
// O(n) Creating a new linked list costs O(n) space.
// O(k) The code above present applies in-place method which cost O(1) space. And the priority queue (often implemented with heaps) costs O(k) space (it's far less than N in most situations).
//https://www.youtube.com/watch?v=XqA8bBoEdIY
