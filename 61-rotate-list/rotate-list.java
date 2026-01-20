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
        if(head==null) return head;

        int size=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            size++;
        }

        k=k%size;
        if(k==0) return head;

        head = reverse(head); // reverse whole list

        temp=head;
        for(int i=0;i<k-1;i++) temp=temp.next;
        ListNode first = head;
        ListNode second = null;
        if(temp!=null) second = temp.next;
        if(temp!=null) temp.next=null;


        first = reverse(first); // reverse first half
        // if(Next==null) return rev;
        second = reverse(second); // reverse second half
        head.next=second;
        return first;
    }
}