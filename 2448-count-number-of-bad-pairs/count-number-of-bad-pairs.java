class Solution {
    public long countBadPairs(int[] nums) {
        long count=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key=nums[i]-i;
            int freq=map.getOrDefault(key,0);
            count = count+i-freq;
            map.put(key,freq+1);
        }
        return count;
    }
}