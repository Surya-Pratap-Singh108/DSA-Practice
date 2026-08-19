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
        int count=1;
        while(count<n){
            last=last.next;
            count++;
        }
        if(last.next == null) return head.next;
        ListNode firstLast=null;
        while(last.next!=null){
            firstLast=first;
            first=first.next;
            last=last.next;
        }
        if(firstLast!=null){
            firstLast.next=first.next;

        }
        
        return head;
    }
}