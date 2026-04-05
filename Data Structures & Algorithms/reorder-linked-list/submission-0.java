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
        /*
            if we split the list into 2 parts;
            2,4(left) and 6,8(right)
            and reverse the right list(8,6)
            and then merge 2,4 and 8,6
            one after another that will work i guess 

            the easiest split algorithm we can find is slow and fast and theres gap
            between the slow and fast by 2

            we can l-(r-l)/2 but we have to calculate the lenth of the list
            that will take us O(n)
        */

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
            ListNode temp1=left.next;
            ListNode temp2=curr.next;
            left.next=curr;
            curr.next=temp1;
            left=temp1;
            curr=temp2;
        }
    }
}
