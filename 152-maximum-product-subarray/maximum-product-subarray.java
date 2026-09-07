class Solution {
    public int maxProduct(int[] nums) {
       int minimum=nums[0]; 
       int maximum=nums[0];
       int max=nums[0];
       for(int i=1;i<nums.length;i++){
           int v1=nums[i];
           int v2=minimum*v1;
           int v3=maximum*v1;
           int currMax=Math.max(v1,Math.max(v2,v3));
           maximum=currMax;
           minimum=Math.min(v1,Math.min(v2,v3));
           max=Math.max(max,currMax);
           
       }
       return max;
    }
}
