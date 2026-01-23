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
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode Next=head;
        while(curr!=null){
            Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        return prev;
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode l=head;
        ListNode r=head;
        ListNode prev=null;
        head=head.next;
        while(r!=null){
            r=l.next;
            if(r==null) return head;
            ListNode Rnext = (r==null)?null:r.next;
            if(r!=null) r.next=null;
            ListNode rev = reverse(l);
            l.next=Rnext;
            if(prev!=null) prev.next=r;
            prev=l;
            l=Rnext;
            r=Rnext;
        }
        return head;
    }
}