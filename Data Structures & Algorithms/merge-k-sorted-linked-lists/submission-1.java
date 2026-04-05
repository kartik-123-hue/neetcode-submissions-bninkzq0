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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
       for(int i=1;i<lists.length;i++){
            lists[i]=mergeTwoSortedList(lists[i],lists[i-1]);
       } 
       return lists[lists.length-1];
    }
    public ListNode mergeTwoSortedList(ListNode list1,ListNode list2){
        ListNode dummyNode =new ListNode(0);
        ListNode dummyIter=dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                dummyIter.next=list1;
                list1=list1.next;
            }
            else{
                dummyIter.next=list2;
                list2=list2.next;
            }
             dummyIter=dummyIter.next;
        }
        while(list1!=null){
            dummyIter.next=list1;
            list1=list1.next;
            dummyIter=dummyIter.next;
        }
        while(list2!=null){
            dummyIter.next=list2;
            list2=list2.next;
            dummyIter=dummyIter.next;
        }
        return dummyNode.next;
    }
}
