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
        HashMap<Node,Node> table=new HashMap<>();
        Node temp=head;
        while(temp!=null){
            table.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            table.get(temp).next=table.get(temp.next);
            table.get(temp).random=table.get(temp.random);
            temp=temp.next;
        }
        return table.get(head);
    }
}
