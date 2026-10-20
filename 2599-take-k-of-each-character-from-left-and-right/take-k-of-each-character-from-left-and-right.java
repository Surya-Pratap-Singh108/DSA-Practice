class Solution {
    public int takeCharacters(String s, int k) {
        int a=0;
        int b=0;
        int c=0;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='a')a++;
            else if(curr=='b')b++;
            else c++;
        }
        if (a < k || b < k || c < k) {
            return -1;
        }
        int left=0;
        int maxInValid=0;
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('b',0);
        map.put('c',0);
        for(int right=0;right<s.length();right++){
            char curr=s.charAt(right);
            map.put(curr,map.get(curr)+1);
            if(map.get('a')>a-k||
                map.get('b')>b-k||
                map.get('c')>c-k
                )
                {
                   map.put(s.charAt(left),map.get(s.charAt(left))-1);
                   left++;
                }
            
            maxInValid=Math.max(right-left+1,maxInValid);
        }
        return s.length()-maxInValid;
    }
}