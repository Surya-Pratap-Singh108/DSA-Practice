class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int count=0;
        int midEle=nums[nums.length/2];
        
        for(int ele:nums){
            count+=Math.abs(ele-midEle);
        }
        
        return count;
    }
}