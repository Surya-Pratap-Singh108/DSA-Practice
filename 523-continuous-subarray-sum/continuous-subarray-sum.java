class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        map.put(0,-1);
        int runningSum=0;
        
        for (int i=0;i<nums.length ;i++ ){
            
            runningSum+=nums[i];
            int mod=runningSum%k;
            if(mod<0){
                mod+=k;
            }
            if (map.containsKey(mod)) {

            if (i - map.get(mod) > 1)
                return true;

            } else {
                map.put(mod, i);
            }
            
        }

        
        return false;
    }
}