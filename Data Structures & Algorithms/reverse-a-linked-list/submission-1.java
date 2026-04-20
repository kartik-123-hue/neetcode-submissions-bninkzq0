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
    public ListNode reverseList(ListNode head) {
        
        /*
        this if visualised 
        [0,1,2,3]
        null->0->1->2->3->null
        reverse
        null->3->2->1->0->null
        */

        //if you can see the 0 points to null that mean there should be a node as null

        ListNode prev=null;
        //the current one will be the head
        ListNode curr=head;
        while(curr!=null){
            //0->1 (1)-will be next node
            ListNode next=curr.next;
            curr.next=prev;//0->null
            prev=curr;//0 became the prev as next will 1
            curr=next;//1 is the head now
            //after this loop(1) list will have formed somewhat
            //1->0->null
        }
        return prev;
    }
}
