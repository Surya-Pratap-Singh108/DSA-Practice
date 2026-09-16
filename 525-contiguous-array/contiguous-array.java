class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int zeros=0;
        int ones=0;
        int length=0;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==0)zeros++;
            
            else ones++;
            
            int diff=ones-zeros;
            
            if(map.containsKey(diff)){
                length=Math.max(length,i-map.get(diff));
            }
            else{
                map.put(diff,i);   
            }
            
        }
        
        return length;
    }
}