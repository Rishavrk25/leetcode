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
    public ListNode rotateRight(ListNode head, int k) {
        int size=0;
        ListNode t=head;
        while(t!=null){
            size++;
            t=t.next;
        }
        if(size==0) return head;
        k=k%size;
        if(k==0) return head;
        head = reverse(head);
        ListNode l1 = head;
        ListNode temp = head;
        for(int i=0;i<k-1;i++) temp=temp.next;
        ListNode l2=null;
        if(temp!=null) l2=temp.next;
        if(temp!=null) temp.next=null;
        l1=reverse(l1);
        l2=reverse(l2);
        temp=l1;
        while(temp.next!=null) temp=temp.next;
        temp.next=l2;
        return l1;
    }
}