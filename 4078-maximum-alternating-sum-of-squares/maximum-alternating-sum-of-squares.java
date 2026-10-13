class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        
        for(int curr:nums){
            minHeap.offer(Math.abs(curr));
            maxHeap.offer(Math.abs(curr));
        }
        long ans=0;
        int i=0;
        while(i<n/2){
            int large=maxHeap.poll();
            int small=minHeap.poll();
            ans=ans+(large*large);
            ans=ans-(small*small);
            i++;
        }
        if(n%2!=0)ans+=(maxHeap.peek()*maxHeap.peek());
        
        return ans;
    }
}