class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int currProduct=1;
        int count=0;
        int left=0;
        int right=0;
        while(right<nums.length){
            currProduct=currProduct*nums[right];
            while(currProduct>=k){
               currProduct/=nums[left];
               left++;
                
            }
            count=count+right-left+1;
            right++;
        }
        return count;
    }
}