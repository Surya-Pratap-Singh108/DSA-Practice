class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0&&nums[i]==nums[i-1])continue;
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int currSum=nums[i]+nums[left]+nums[right];
                if(currSum==0){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while(left < right &&
                        nums[left] == nums[left-1] &&
                        nums[right] == nums[right+1])
                        {
                         left++;
                         right--;   
                        }
                }
                else if(currSum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return ans;
    }
}