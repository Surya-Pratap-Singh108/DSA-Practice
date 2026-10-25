class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int group= 1;
        pq.offer(intervals[0][1]);
        
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>pq.peek()){//cam be in same group
                pq.poll();
                pq.offer(intervals[i][1]);
                
            }
            else{//new group (overlapp)
                group++;
                pq.offer(intervals[i][1]);
            }
        }
        return group;
    }
}