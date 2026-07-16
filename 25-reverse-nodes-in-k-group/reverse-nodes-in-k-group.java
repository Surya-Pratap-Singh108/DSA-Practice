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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode left=head;
        ListNode preNewLast=null;
        ListNode newLeft=null;
        ListNode result=null;
        while(true){
            int size=k;
            ListNode right=left;
            while(right!=null&&size>1){
                right=right.next;
                size--;
            }
            if(right!=null){
                newLeft=right.next;
                reverse(left,k);
                
                
                if(preNewLast!=null){
                    preNewLast.next=right;
                }
                if(result==null){
                    result=right;
                }
                preNewLast=left;
                left=newLeft;
                
            }
            else{
                if(preNewLast!=null){
                    preNewLast.next=left;
                }
                if(result==null){
                    result=right;
                }
                break;
            }
        }
        
        return result;
	}
	
	public void reverse(ListNode head,int times){
	    ListNode pre=null;
	    ListNode curr=head;
	    ListNode next=null;
	    for(int i=0;i<times;i++){
	        next=curr.next;
	        curr.next=pre;
	        pre=curr;
	        curr=next;
	    }
	    return ;
	}
}