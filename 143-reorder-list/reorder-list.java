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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp=slow;
        slow=slow.next;
        temp.next=null;//to cut connection
        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode first = head;
        ListNode second = prev;
        ListNode tail = first;

        while (first != null && second != null) {

            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            tail.next = second;
            tail = tail.next;

            if (firstNext != null) {
                tail.next = firstNext;
                tail =tail.next;
            }

            first = firstNext;
            second = secondNext;
        }
    }
}