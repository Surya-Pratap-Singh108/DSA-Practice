class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int max=0;
        for(int right=0;right<s.length();right++){
           while(map.containsKey(s.charAt(right))){
               map.put(s.charAt(left),map.get(s.charAt(left))-1);
            //   if(map.get(left)==0){
               
            //       map.remove(left);
            //   }
                   map.remove(s.charAt(left));
               left++;
           }
           map.put(s.charAt(right),1);
        //   map.put(map.getOrDefault(map.get(s.charAt(right)),0)+1);
           max=Math.max(max,right-left+1); 
        }
        return max;
    }
}