class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target)return mid;
            if(nums[mid]<nums[end]){
                if(nums[mid]<target&&target<=nums[end]) return binary(nums,mid+1,end,target);
                else end=mid-1;
            }
            else{
                if(nums[start]<=target&&target<nums[mid]) return binary(nums,start,mid-1,target);
                else start=mid+1;
            }
        }
        return -1;
    }
    public int binary(int[]nums,int start,int end,int target){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}