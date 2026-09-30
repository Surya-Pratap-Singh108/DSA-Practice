class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start1=intervals[0][0];
        int end1=intervals[0][1];
        int count=0;
        for(int i=1;i<intervals.length;i++){
            if(end1<=intervals[i][0]){//no overlapping
                start1=intervals[i][0];
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