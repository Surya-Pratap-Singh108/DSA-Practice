class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode newHead = second;
        ListNode nextFirst = null;
        ListNode prev = null;

        while (first != null && second != null) {

            nextFirst = second.next;

            second.next = first;
            first.next = nextFirst;

            if (prev != null) {    
                prev.next = second;
            }

            prev = first;          

            first = nextFirst;

            if (first != null)
                second = first.next;
            else
                second = null;
        }

        return newHead;
    }
}