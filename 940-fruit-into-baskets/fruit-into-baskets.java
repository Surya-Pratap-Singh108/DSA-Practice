class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int left=0;
        int ans=0;
        for(int right=0;right<fruits.length;right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size()>2){
                int preFruit=fruits[left];
                map.put(preFruit,map.get(preFruit)-1);
                if(map.get(preFruit)==0){
                    map.remove(preFruit);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}