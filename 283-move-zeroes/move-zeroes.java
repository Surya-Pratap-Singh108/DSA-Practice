class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]!=0){
               swap(nums,i,index);
               index++;
            }
            i++;
        }
    }
    public void swap(int[] nums,int i,int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}