class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int prefixSum=0;
        map.put(prefixSum,1);
        int count=0;
        for(int num:nums){
            prefixSum+=num;
            
            // map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);

            
            count+=map.getOrDefault(prefixSum-k,0);
            
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        
        return count;

    }
}