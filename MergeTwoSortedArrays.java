/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * 
 * TC- O(N+M)
 * SC - O(N+M)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode result = new ListNode(0);
        ListNode dummy = result;
        while(l1!=null && l2!= null){
            if(l1.val <= l2.val){
                result.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                result.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        if(l1!=null){
            result.next = l1;
        }
        if(l2!=null)
            result.next = l2;
        
        return dummy.next;
    }
}