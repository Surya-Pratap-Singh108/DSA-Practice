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
    public int pairSum(ListNode head) {
       int ans=Integer.MIN_VALUE; 
       ListNode slow=head;
       ListNode fast=head;
       
       while(fast.next.next!=null){
           slow=slow.next;
           fast=fast.next.next;
       }
       ListNode reverseList=reverse(slow.next);
       slow.next=null;
       while(head!=null){
           int currSum=head.val+reverseList.val;
           ans=Math.max(ans,currSum);
           head=head.next;
          reverseList=reverseList.next;
       }
       return ans;
    }
    private ListNode reverse(ListNode node){
        ListNode pre=null;
        ListNode curr=node;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
}