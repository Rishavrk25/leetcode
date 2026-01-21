/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node d=dummy;
        Map<Node,Node> map=new HashMap<>(); // node, random node
        Node temp=head;
        while(temp!=null){
            Node newNode = new Node(temp.val);
            map.put(temp,newNode);
            d.next=newNode;
            d=d.next;
            temp=temp.next;
        }
        
        Node curr=head;
        Node newcurr=dummy.next;
        while(curr!=null){
            newcurr.random = map.get(curr.random);
            curr=curr.next;
            newcurr=newcurr.next;
        }
        return dummy.next;
        
    }
}