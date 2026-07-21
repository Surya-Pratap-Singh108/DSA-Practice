class Solution {
    public int[] searchRange(int[] nums, int target) {
     int[]ans={-1,-1};
        //check for first occarance
      int start=search(nums,target,true);
      int end=search(nums,target,false);
      ans[0]=start;
      ans[1]=end;
        return ans;
    }
    //this function return the index value of key
    static int search(int[]arr,int target,boolean findstartindex){
        int ans=-1;
        int start=0;
        int end=arr.length-1;
        while(start<=end) {
            // int mid = (start + end) / 2;//might be pssible that(start+end) exceeds the range of integer in java so
            int mid = start + (end-start) / 2;
            if (target == arr[mid]) {
                ans=mid; //potational answer is found
                if(findstartindex){
                    end=mid-1;
                }else {
                    start=mid+1;
                }
            } 
            else if (target < arr[mid]) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
