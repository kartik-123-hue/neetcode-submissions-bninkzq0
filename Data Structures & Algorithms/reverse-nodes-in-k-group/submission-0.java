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
    public ListNode reverseKGroup(ListNode head, int k) {
       ListNode dummy=new ListNode(0,head);
       ListNode dummyTemp=dummy;
       while(true){
        ListNode kth=getKth(dummyTemp,k);
        if(kth==null){
            break;
        }
        ListNode groupNext=kth.next;
        ListNode prev=kth.next;
        ListNode curr=dummyTemp.next;
        while(curr!=groupNext){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode temp=dummyTemp.next;
        dummyTemp.next=kth;
        dummyTemp=temp;
       }
       return dummy.next;
    }

    public ListNode getKth(ListNode head,int k){
        ListNode temp=head;
        while(temp!=null && k!=0){
            temp=temp.next;
            k--;
        }
        return temp;
    }
}
