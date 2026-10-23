class Solution {
    public int minimumIndex(List<Integer> nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int dominant=0;
        int n=nums.size();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if((map.get(num)*2)>n){
                dominant=num;
            }
        }
        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums.get(i)==dominant){
                count++;
                if(count*2>i+1&&(map.get(dominant)-count)*2>n-i-1)return i;
            }
            
        }
        return -1;
    }
}