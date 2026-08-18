class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right){
            return head;
        }
        ListNode leftEnd=null;
        ListNode rightStart=null;
        int count = 1;
        ListNode temp=head;
        while(count<=right+1){
            if(count==left-1){
                leftEnd=temp;
            }
            if(count==right+1){
                rightStart=temp;
                break;
            }
            temp=temp.next;
            count++;
        }
        ListNode newEnd=null;
        ListNode reversePart=null;
        if(leftEnd!=null){
            newEnd=leftEnd.next;
            reversePart=reverse(leftEnd.next,right-left+1);
            
        }
        else{
            newEnd=head;
            reversePart=reverse(head,right-left+1);

        }
        newEnd.next=rightStart;
        if(left==1){
            head=reversePart;
            return head;
        }
        leftEnd.next=reversePart;
        return head;
	}
	public ListNode reverse(ListNode head,int total){
	    int count=0;
	    ListNode pre=null;
	    while(count<total){
	        ListNode next=head.next;
	        head.next=pre;
	        pre=head;
	        head=next;
	        count++;
	    }
	    return pre;
	}
}