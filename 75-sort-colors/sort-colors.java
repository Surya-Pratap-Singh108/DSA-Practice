class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            int currMid=nums[mid];
            if(currMid==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(currMid==1){
                mid++;
            }
            else{
                swap(nums,mid,high);

                high--;
            }
        }
    }
    public void swap(int[]nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}