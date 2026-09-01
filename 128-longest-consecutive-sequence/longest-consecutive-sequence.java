class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.add(num);
        }
        int max=0;
        while(!pq.isEmpty()){
            int currElement=pq.poll();
            int curr=1;
            if(!pq.isEmpty()&&currElement==pq.peek())continue;
            while(!pq.isEmpty()&&pq.peek()==currElement+1){
                currElement=pq.poll();
                curr++;
                while(!pq.isEmpty() && pq.peek() == currElement){
                    pq.poll();
                }
            }
            max=Math.max(max,curr);
        }
        return max;
    }
}