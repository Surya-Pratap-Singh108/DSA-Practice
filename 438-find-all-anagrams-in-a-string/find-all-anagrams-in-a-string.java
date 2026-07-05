class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
         if (p.length() > s.length()){
            return ans;
         };
        int[] pCount= new int[26];
        for (int i = 0; i < p.length(); i++) {
         pCount[p.charAt(i)-'a']++;
        }
        int[] sCount= new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i)-'a']++;
        }
        if(helper(pCount,sCount)){
            ans.add(0);
        }
        for(int i = p.length(); i < s.length(); i++){
            sCount[s.charAt(i-p.length())-'a']--;
            sCount[s.charAt(i)-'a']++;
            if(helper(pCount,sCount)){
            ans.add(i-p.length()+1);
        }
        }
      
        return ans;
	}
	public boolean helper(int [] a,int [] b){
	    for(int i=0;i<a.length;i++){
	        if(a[i]!=b[i]) return false;
	    }
	    return true;
	}
}