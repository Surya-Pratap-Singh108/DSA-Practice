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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry=0;
       ListNode dummy=new ListNode(0);
       ListNode result=dummy;
       while(l1!=null||l2!=null){
           int currentVal=carry;
           if(l1!=null){
               currentVal+=l1.val;
               l1=l1.next;
           }
           if(l2!=null){
               currentVal+=l2.val;
               l2=l2.next;
           }
           if(currentVal>=10){
               carry=1;
           }
           else{
            carry=0;
           }
           ListNode temp=new ListNode(currentVal%10);
           result.next=temp;
           result=result.next;
       }
       if(carry>0){
            ListNode temp=new ListNode(carry);
           result.next=temp;
           result=result.next;
       }
       return dummy.next;
    }
}