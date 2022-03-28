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
        if(head.next==null&&n==1)
            return null;
        int l=1;
        ListNode p=head;
        while(p.next!=null){
            p=p.next;
            l++;
        }
        l-=n;
        if(l==0)
            return head.next;
        
        p=head;
        while(l!=1&&p.next!=null){
            l--;
            p=p.next;               
        }
        ListNode q=p.next.next;
        p.next=q;
        return head;
    }
}