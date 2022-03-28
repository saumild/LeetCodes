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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy1 = dummy;
        ListNode dummy2 = dummy;
        
        for(int i = 0; i<= n; i++){
            dummy1 = dummy1.next;
        }
        
        while(dummy1 != null){
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }
        
        dummy2.next = dummy2.next.next;
        
        return dummy.next;
    }
}