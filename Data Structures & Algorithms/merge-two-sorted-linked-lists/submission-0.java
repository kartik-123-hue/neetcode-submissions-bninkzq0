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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        /*
            we can iterate  the list at the same time
            list1 1,2,4;
            list2 1,3,5
            dummyNode-->for the start
            mark it as 0
            dummy.next=will be decided by the comparision of both nodes
        */

        ListNode dummyNode=new ListNode(0);
        ListNode dummy=new ListNode();
        dummy=dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummy.next=new ListNode(list1.val);
                list1=list1.next;
            }
            else{
                dummy.next=new ListNode(list2.val);
                list2=list2.next;
            }
            dummy=dummy.next;
        }
        while(list1!=null){
            dummy.next=new ListNode(list1.val);
            list1=list1.next;
            dummy=dummy.next;
        }
        while(list2!=null){
            dummy.next=new ListNode(list2.val);
            list2=list2.next;
            dummy=dummy.next;
        }
        return dummyNode.next;
    }
}