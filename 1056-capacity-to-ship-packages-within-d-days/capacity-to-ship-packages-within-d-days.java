class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int weight:weights){
            high+=weight;
            low=Math.max(low,weight);
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isSatisfy(weights,days,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean isSatisfy(int[]weights,int days,int mid){
        int currCapacity=0;
        int count=1;
        for(int i=0;i<weights.length;i++){
            currCapacity+=weights[i];
            if(currCapacity<=mid)continue;
            else{
                currCapacity=weights[i];
                count++;
            }
        }
        return count<=days;
    }
}