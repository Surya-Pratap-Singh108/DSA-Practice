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
    private ListNode middlenode(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
     public ListNode reverseList(ListNode head) {
     if(head==null||head.next==null){
         return head;
     }
     ListNode pre=null;
     ListNode next=head;
     while(head!=null){
         next= head.next;
         head.next=pre;
         pre=head;
         head=next;

     }
     head=pre;
     return head;
 }
    public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
        return;
    }
    ListNode mid = middlenode(head);

    ListNode second = mid.next;
    mid.next = null;          // Break the list first

    ListNode head2nd = reverseList(second);
    ListNode head1st = head;
    while (head2nd != null) {
        ListNode start = head1st.next;
        ListNode end = head2nd.next;

        head1st.next = head2nd;
        head2nd.next = start;

        head1st = start;
        head2nd = end;
    }
   }
}