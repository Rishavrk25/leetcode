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

        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<k;i++) fast=fast.next;
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        ListNode newHead = slow.next;
        slow.next=null;
        fast.next=head;
        return newHead;
    }
}