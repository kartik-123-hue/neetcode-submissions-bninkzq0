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
    public void reorderList(ListNode head) {
        //we can find half of linked list using slow and fast pointer
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode curr=slow.next;
        ListNode prev=slow.next=null;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        ListNode left=head;
        curr=prev;
        while(left!=null && curr!=null){
            ListNode next1=left.next;
            ListNode next2=curr.next;
            left.next=curr;
            curr.next=next1;
            left=next1;
            curr=next2;
        }
    }
}
