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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l = list1;
        ListNode r = list1;
        for(int i=0;i<a-1;i++) l=l.next;
        for(int i=0;i<b+1;i++) if(r!=null) r=r.next;
        l.next=list2;
        while(l.next!=null) l=l.next;
        l.next=r;
        return list1;
    }
}