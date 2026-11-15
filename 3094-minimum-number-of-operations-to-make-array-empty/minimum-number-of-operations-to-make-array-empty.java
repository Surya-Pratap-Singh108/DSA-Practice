class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        int ans=0;
        for(Map.Entry<Integer,Integer> curr : map.entrySet()){
            int currKey=curr.getKey();
            int currVal=curr.getValue();
            if(currVal==1)return -1;
            // if(currVal%3==0) ans=ans+currVal/3;
            // else if(currVal%3==1) ans=ans+(currVal-4)/3+2;
            // else ans=ans+currVal/3+1;
            ans += (currVal + 2) / 3;
        }
        
        return ans;
    }
}