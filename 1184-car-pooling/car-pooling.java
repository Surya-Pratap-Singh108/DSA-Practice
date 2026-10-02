class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->Integer.compare(a[1],b[1]));
        int currCap=0;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));//destination, with no. of passenger
        for(int[] curr:trips){
            while(!minHeap.isEmpty()&&minHeap.peek()[0]<=curr[1]){
                currCap-=minHeap.poll()[1];//decrease no. of passenger 
            }
            
            minHeap.offer(new int[]{curr[2],curr[0]});
            currCap+=curr[0];
            if(currCap>capacity)return false;
        }
        return true;
    }
}