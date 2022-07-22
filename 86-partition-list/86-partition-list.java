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
    public ListNode partition(ListNode head, int x) {
        ListNode l1Dummy = new ListNode(0);
        ListNode l1 = l1Dummy;
        ListNode l2Dummy = new ListNode(0);
        ListNode l2 = l2Dummy;
        
        
        while(head != null){
            if(head.val<x){
                
                l1.next = head;
                l1 = l1.next;
            }else{
                
                l2.next = head;
                l2 = l2.next;
            }
            head = head.next;
        }
        l2.next = null;
        l1.next = l2Dummy.next;
        return l1Dummy.next;
    }
}