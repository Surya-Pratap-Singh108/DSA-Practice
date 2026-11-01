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
    public ListNode removeNodes(ListNode head) {
        ListNode revHead = reverse(head);
        ListNode node = revHead;
        while(node.next!=null){
            ListNode nextt = node.next;
            if(nextt.val < node.val){
                node.next=nextt.next;
            }
            else{
                node=node.next;
                
            }
        }
        
        return reverse(revHead);
    }
    
    
    public ListNode reverse(ListNode node){
        ListNode pre=null;
        while(node!=null){
            ListNode next = node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}