class Solution {
    public long countSubarrays(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxElem=Integer.MIN_VALUE;
        for(int num:nums){
            maxElem=Math.max(maxElem,num);
        }
        long ans=0;
        int count=0;
        int left=0;
        int right=0;
        while(right<nums.length){
            if(nums[right]==maxElem)count++;
            while (count >= k) {
                if (nums[left] == maxElem) count--;
                left++;
            }

            ans += left;
            
            right++;
        }
        
        return ans;
    }
}
