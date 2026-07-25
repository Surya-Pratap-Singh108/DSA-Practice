class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length<k)return -1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        for(int i=0;i<nums.length;i++){
            
            pq.add(nums[i]);
            
            if(i>k-1){
                pq.remove();
            }
        }
        return pq.remove();
        
	}
}