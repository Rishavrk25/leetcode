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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode l=head;
        ListNode r=head;
        for(int i=0;i<k-1;i++){
            head=head.next;
        }
        ListNode prev=null;
        while(r!=null){
            for(int i=0;i<k-1;i++){
                r=r.next;
                if(r==null) return head;
            }
            
            ListNode Rnext=null;
            if(r!=null) Rnext=r.next;

            if(r!=null) r.next=null;
            ListNode rev = reverse(l);

            if(prev!=null) prev.next=r;
            l.next=Rnext;

            prev=l;
            l=Rnext;
            r=Rnext;
        }
        return head;
    }
}