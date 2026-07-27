class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
                return b[0]-a[0];//max Heap
            }
        );
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<profits.length;i++){
            pq.offer(new int[]{profits[i],capital[i]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a,b)->{
                return a[0]-b[0];//min Heap
            }
            );
        while(k>0){
            while(!pq.isEmpty()&&pq.peek()[1]>w){
                int[] temp=pq.poll();
                q.offer(new int[]{temp[1],temp[0]});
                
            }
            if(pq.isEmpty()) return w;
            int[] curr=pq.poll();
            w+=curr[0];
            k--;
            
            while(!q.isEmpty()&&q.peek()[0]<=w){
                int[] temp=q.poll();
                pq.offer(new int[]{temp[1],temp[0]});
            }
            
        }
        return w;
    }
}