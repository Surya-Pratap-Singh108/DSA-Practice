class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int zero=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zero=i;
                break;
            }
        }
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 0; i < n; i++) {
            int right=(zero+i)%n;
            int left=(zero-i+n)%n;
            if (nums[right] != i) {
                increasing = false;
            }
        
            if (nums[left] != i) {
                decreasing = false;
            }
        }
        int ans=Integer.MAX_VALUE;
        if(increasing){
            ans=Math.min(ans,Math.min(zero,n-zero+2));
        }
        else if(decreasing){
            ans=Math.min(ans,Math.min(zero+2,n-zero));
        }
        
        return ans==Integer.MAX_VALUE? -1:ans;
    }
}