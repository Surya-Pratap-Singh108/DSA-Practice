/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Boolean> map=new HashMap<>();
        // HashSet<ListNode> set=new HashSet<>();
        
        while(headA!=null){
            map.put(headA,true);
            // set.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if(map.containsKey(headB))break;
            // if(set.contains(headB))break;
            headB=headB.next;
        }
        return headB;
    }
}