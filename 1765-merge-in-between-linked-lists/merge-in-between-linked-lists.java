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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode temp=list1;
        ListNode start=null;
        ListNode end=null;
        for(int i=0;i<b;i++){
            if(i==a-1)start=temp;
            temp=temp.next;
        }
        end=temp.next;
        start.next=list2;
        temp=list2;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=end;
        return list1;
    }
}