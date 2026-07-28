class Solution {
    public int lastStoneWeight(int[] stones) {
        
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(
            (a,b)->b-a
            );
            
            
        for(int num:stones){
            pq.offer(num);
        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            
            int newWeight=first-second;
            
            if(newWeight!=0){
            pq.offer(newWeight);
            }
            
        }
        if(pq.size()==1)return pq.poll();
        return 0;
	}
}