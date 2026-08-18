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

        // 1. Find middle and split
        ListNode slow = head;
        ListNode fast = head;
        ListNode firstLast = null;

        while (fast != null && fast.next != null) {
            firstLast = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // First half ends here
        firstLast.next = null;

        // 2. Reverse second half
        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // 3. Merge
        ListNode first = head;
        ListNode second = prev;
        ListNode tail = first;

        while (first != null && second != null) {

            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            tail.next = second;
            tail = second;

            if (firstNext != null) {
                tail.next = firstNext;
                tail = firstNext;
            }

            first = firstNext;
            second = secondNext;
        }

        // Odd-length list: one node remains in second half
        if (second != null) {
            tail.next = second;
        }
    }
}