class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans=Integer.MAX_VALUE;
        for (int right = 0; right < nums.size(); right++) {
            int sum = 0;
        
            for (int left = right;
                 left >= 0 && right - left + 1 <= r;
                 left--) {
        
                sum += nums.get(left);
        
                int length = right - left + 1;
        
                if (length >= l && sum > 0) {
                     ans=Math.min(ans,sum); 
                }
            }
        }
        
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}