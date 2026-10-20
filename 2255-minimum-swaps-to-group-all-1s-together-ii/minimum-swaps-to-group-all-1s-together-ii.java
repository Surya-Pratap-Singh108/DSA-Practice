class Solution {
    public int minSwaps(int[] nums) {
        int totalOnes=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)totalOnes++;
        }
        int zerosInW=0;
        int swaps=Integer.MAX_VALUE;
        for(int i=0;i<totalOnes;i++){
            if(nums[i]==0)zerosInW++;
        }
        
        swaps=Math.min(zerosInW,swaps);
        
        for(int i=totalOnes;i<nums.length+totalOnes-1;i++){
            if(nums[i-totalOnes]==0)zerosInW--;
            if(nums[i%nums.length]==0)zerosInW++;
            swaps=Math.min(zerosInW,swaps);
        }
        
        return swaps;
    }
}