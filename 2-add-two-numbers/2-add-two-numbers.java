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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        while(l1!= null || l2 != null){
            int sum = 0,x =0, y =0;
            
            if(l1!=null)
                x = l1.val;
            else
                x = 0;
            if(l2 != null)
                y = l2.val;
            else
                y = 0;
            sum = x + y + carry;
            ans.next = new ListNode(sum%10);
            carry = sum/10;
            if(l1!= null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
            ans = ans.next;
            
            if(carry>0){
                ans.next = new ListNode(carry);
            }
                
        }
        
        return head.next;
    }
}