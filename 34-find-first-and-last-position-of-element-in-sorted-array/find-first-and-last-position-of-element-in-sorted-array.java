class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        int[] ans={-1,-1};
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]<target)low=mid+1;
            else if(nums[mid]>target)high=mid-1;
            
            else{
                boolean smallestI=true;
                ans[0]=bSearch(nums,low,mid,target,smallestI);
                ans[1]=bSearch(nums,mid,high,target,!smallestI);
                break;
            }
        }
        return ans;
    }
    public int bSearch(int[]nums,int low,int high,int target,boolean smallestI){
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                index=mid;
                if(smallestI)high=mid-1;
                else low=mid+1;
            }
            else if(target<nums[mid])high=mid-1;
            else low=mid+1;
        }
        return index;
    }
}