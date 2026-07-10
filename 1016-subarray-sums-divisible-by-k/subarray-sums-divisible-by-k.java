class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int count=0;
        int runningSum=0;
        
        for(int i=0;i<nums.length;i++){
            runningSum+=nums[i];
            int mod=runningSum%k;
            if(mod<0)mod=mod+k;
            if(map.containsKey(mod)){
                count+=map.get(mod);
            }
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        
        return count;
	}
}