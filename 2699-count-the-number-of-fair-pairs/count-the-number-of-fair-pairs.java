class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int lIndex=bSearch(nums,i+1,nums.length-1,lower-nums[i],true);
            int hIndex=bSearch(nums,i+1,nums.length-1,upper-nums[i],false);
            if (lIndex != -1 && hIndex != -1 ) {
                ans += hIndex - lIndex + 1;
            }
        }
        
        return ans;
    }
    public int bSearch(int[] nums,int l, int h,int target,boolean lower){
        int start=l;
        int end=h;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(lower){
                if(nums[mid]>=target){
                    index=mid; 
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else{
                if(nums[mid]<=target){
                    index=mid; 
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
        }
        return index;
    }
}