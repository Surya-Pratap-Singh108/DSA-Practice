class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right)
            return head;

        int count = 1;

        ListNode curr = head;      
        ListNode leftLast = null;

        while (count < left) {
            leftLast = curr;
            curr = curr.next;
            count++;
        }

        ListNode first = curr;
        ListNode pre = null;
        ListNode next = null;

        while (count <= right) {     
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            count++;
        }
        first.next = curr;
        if (leftLast != null) {
            leftLast.next = pre;
            return head;
        }
        return pre;
    }
}