class Solution {
  public int[] twoSum(int[] nums, int target) {
   HashMap<Integer,Integer> h=new HashMap<>();
    for(int i=0;i<nums.length;i++)
    {
        int current=nums[i];
        int complement=target-current;
        if(h.containsKey(complement)){
          return new int[]{h.get(complement), i};//follow order
        }
        h.put(nums[i],i);
    }
       return new int[] {};
  }

}