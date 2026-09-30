class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int end1=intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(end1<=intervals[i][0]){//no overlapping
                end1=intervals[i][1];
            }
            else{//overlapping
                end1=Math.min(end1,intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}