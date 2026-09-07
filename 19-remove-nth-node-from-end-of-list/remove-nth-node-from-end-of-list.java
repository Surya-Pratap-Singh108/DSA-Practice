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
        int count=1;
        while(count<=n){
            temp=temp.next;
            count++;
        }
        if(temp==null)return head.next;
        ListNode start=head;
        while(temp.next!=null){
            start=start.next;
            temp=temp.next;
        }
        start.next=start.next.next;
        
        return head;
    }
}