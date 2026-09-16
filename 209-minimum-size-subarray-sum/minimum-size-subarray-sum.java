class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0;
        int currSum=0;
        int minLength=Integer.MAX_VALUE;
        for(int high=0;high<nums.length;high++){
            currSum+=nums[high];
           
           while(currSum>=target){
               minLength=Math.min(minLength,high-low+1);
               currSum-=nums[low];
               low++;
           } 
        }
        
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
}