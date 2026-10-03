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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;
        ListNode prev=null;
        if(head.val<x){
            prev=head;
            while(prev.next!=null&&prev.next.val<x){
                prev=prev.next;
            }
            if(prev.next == null) return head;
        }
        ListNode curr=prev==null?head:prev.next;

        while(curr.next!=null){
            if(curr.next.val>=x){
                curr=curr.next;
            }
            else{
                ListNode temp=curr.next;
                curr.next=temp.next;
                if(prev==null){
                    
                    temp.next=head;
                    head=temp;
                    prev=temp;
                }
                else{
                    
                    
                    temp.next=prev.next;
                    prev.next=temp;
                    prev=temp;
                }
           }
        }
        return head;
    }
}