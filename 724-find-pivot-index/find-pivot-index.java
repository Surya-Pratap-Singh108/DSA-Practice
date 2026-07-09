class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum=new int[nums.length];
        int[] suffixSum=new int[nums.length];
        for (int i=1;i<nums.length ;i++ ){
            prefixSum[i]=prefixSum[i-1]+nums[i-1];
        }
        for (int i=nums.length-2;i>=0 ;i--){
            suffixSum[i]=suffixSum[i+1]+nums[i+1];
        }
        if(suffixSum[0]==0){
            return 0;
        }
        for(int i=1;i<nums.length-1;i++){
            if(suffixSum[i-1]==prefixSum[i+1]){
                return i;
            }
        }
        if(prefixSum[nums.length-1]==0){
            return nums.length-1;
        }
        return -1;
	}
}