class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int []preMultiple=new int[n];
        int []postMultiple=new int[n];
        int []ans=new int[n];
        preMultiple[0]=1;
        postMultiple[n-1]=1;
        for(int i=1;i<n;i++){
            preMultiple[i]=preMultiple[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            postMultiple[i]=postMultiple[i+1]*nums[i+1];
        }
        for(int i=0;i<n;i++){
            ans[i]=preMultiple[i]*postMultiple[i];
        }
        return ans;
    }
}