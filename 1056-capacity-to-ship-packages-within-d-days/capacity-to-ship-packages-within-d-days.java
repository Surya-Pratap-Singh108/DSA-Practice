class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=maximum(weights);
        int high=totalSum(weights);
        int ans=high;
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
    
    public boolean isSatisfy(int[] weights,int days,int maxCapacity){
        
        int currCapacity=0;
        int currDays=1;
        for(int num:weights){
            if(currCapacity+num<=maxCapacity){
                currCapacity+=num;

            }
            else{
                currCapacity=num;
                currDays++;
            }
            
            
        }
        if(currDays<=days)return true;
        return false;
        
        
    }
    public int totalSum(int[] weights){
        int total=0;
        for(int num:weights){
            total+=num;
        }
        return total;
    }
    public int maximum(int[] weights){
        int max=Integer.MIN_VALUE;
        for(int num:weights){
            max=Math.max(max,num);
        }
        return max;
    }
}