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

        ListNode first=head;
        ListNode last=head;
        int count=0;
        while(count<n){
            last=last.next;
            count++;
        }
        if(last == null) return head.next;
        while(last.next!=null){
            first=first.next;
            last=last.next;
        }
        
        first.next=first.next.next;

        
        
        return head;
    }
}