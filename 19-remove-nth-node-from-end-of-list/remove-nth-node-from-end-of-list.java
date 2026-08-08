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
//     public ListNode removeNthFromEnd(ListNode head, int n) {
//         if(head==null)return head;
//         int count=totalnodes(head);
//         //now we have to return count-n+1th from front
//         int from_front=count-n+1;
//         if(from_front==1)return head.next;
//         ListNode temp=head;
//         for (int i=0;i<from_front-2 ;i++ ){
//             temp=temp.next;
//         }
//         temp.next=temp.next.next;
//         return head;
           
//     }
//     //from my thought process
//     // public int totalnodes(ListNode head){
//     //     ListNode slow=head;
//     //     ListNode fast=head;
//     //     int count=1;
//     //     while(fast.next!=null&&fast.next.next!=null){
//     //        slow=slow.next;
//     //        fast=fast.next.next;
//     //        count++;
//     //     }
//     //     if(fast.next==null) return 2*count-1;
//     //     else return 2*count;
//     // }
//     // from chatgpt
//     public int totalnodes(ListNode head) {
//     int count = 0;
//     while (head != null) {
//         count++;
//         head = head.next;
//     }
//     return count;
// }
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = head;
    ListNode second = head;

    // Step 1: Move 'first' n steps ahead
    for (int i = 0; i < n; i++) {
        first = first.next;
    }

    // Case: remove the head
    if (first == null) {
        return head.next;
    }

    // Step 2: Move both pointers until 'first' reaches the last node
    while (first.next != null) {
        first = first.next;
        second = second.next;
    }

    // Step 3: Delete the target node
    second.next = second.next.next;

    return head;
}


}