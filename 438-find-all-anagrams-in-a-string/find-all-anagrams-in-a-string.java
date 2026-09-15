class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans=new LinkedList<>();

        if(p.length()>s.length())return ans;
        int[]need=new int[26];
        int[]have=new int[26];
        for(int i=0;i<p.length();i++){
            need[p.charAt(i)-'a']++;
        }
        
        int low=0;
        
        
        for(int high=0;high<s.length();high++){
            have[s.charAt(high)-'a']++;
            if(high>=p.length()-1){
                if(fun(have,need)){
                    ans.add(low);
                    
                }
                have[s.charAt(low)-'a']--;
                low++;
            }
            
        }
        return ans;
    }
    public boolean fun(int[]have,int[]need){
        for(int i=0;i<26;i++){
            if(have[i]!=need[i])return false;
        }
        return true;
    }
    
}