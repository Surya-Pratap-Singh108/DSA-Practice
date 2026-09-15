class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        int[]need=new int[256];
        int[]have=new int[256];
        for(int i=0;i<t.length();i++){
            need[t.charAt(i)]++;
        }
        
        int low=0;
        int start=-1;
        int resultLength=Integer.MAX_VALUE;
        
        for(int high=0;high<s.length();high++){
            have[s.charAt(high)]++;
            while(fun(have,need)){
                int currLength=high-low+1;
                if(currLength<resultLength){
                    resultLength=currLength;
                    start=low;
                }
                have[s.charAt(low)]--;
                low++;
            }
        }
        return start==-1?"":s.substring(start,start+resultLength);
    }
    public boolean fun(int[]have,int[]need){
        for(int i=0;i<256;i++){
            if(have[i]<need[i])return false;
        }
        return true;
    }
}