class Solution {
    public int splitArray(int[] nums, int k) {
    int  start=0;
        int end=0;
        for (int i = 0; i < nums.length; i++) {
            start=Math.max(start,nums[i]);//in the end of the loop this contain largest element
            end+=nums[i];
        }//binary search
        
        int ans=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(isSatisfy(nums,k,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        
        return ans;
	}
	public boolean isSatisfy(int[] nums,int k,int ans){
	    int currSum=0;
	    int parts=1;
	    for(int num:nums){
	        if(currSum+num<=ans){
	            currSum+=num;
	        }
	        else{
	            currSum=num;
                parts++;
	        }
	    }
	    if(parts<=k)return true;
	    return false;
	}
}