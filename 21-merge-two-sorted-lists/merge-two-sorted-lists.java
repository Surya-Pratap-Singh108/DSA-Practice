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
        ListNode temp1=list1;
        ListNode temp2=list2;
        ListNode dummy=new ListNode(0);
        ListNode result=dummy;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                result.next=temp1;
                temp1=temp1.next;
            }
            else{
                result.next=temp2;
                temp2=temp2.next;
            }
            result=result.next;
        }
        if(temp1!=null){
            while(temp1!=null){
                result.next=temp1;
                temp1=temp1.next;
                result=result.next;
            }
        }
        else{
            while(temp2!=null){
                result.next=temp2;
                temp2=temp2.next;
                result=result.next;
            }
        }
        return dummy.next;
    }
}