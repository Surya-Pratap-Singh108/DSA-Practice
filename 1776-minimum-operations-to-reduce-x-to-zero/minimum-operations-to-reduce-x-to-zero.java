class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        int remainingSum=totalSum-x;
        if (remainingSum == 0) return nums.length;
        if (remainingSum < 0) return -1;
        int left=0;
        int currentSum=0;
        int maxLength=0;
        for(int right=0;right<nums.length;right++){
            currentSum+=nums[right];
            while(currentSum>remainingSum){
                currentSum-=nums[left];
                left++;
            }
            if(currentSum==remainingSum){
                maxLength=Math.max(maxLength,right-left+1);
            }
        }
        return maxLength == 0 ? -1 : nums.length - maxLength;
    }
}