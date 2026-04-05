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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int size=0;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int indexToRemove=size-n;
        if(indexToRemove==0){
            return head.next;
        }
        temp=head;
        int i=0;
        while(temp!=null){
            if(i+1==indexToRemove){
                temp.next=temp.next.next;
            }
            temp=temp.next;
            i++;
        }
        return head;
    }
}
