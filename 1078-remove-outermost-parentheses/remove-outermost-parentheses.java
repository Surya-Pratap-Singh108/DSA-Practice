class Solution {
    public String removeOuterParentheses(String s) {
        int start=0;
        int open=0;
        int close=0;
        String ans="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')open++;
            else close++;
            if(open==close){
                ans=ans+s.substring(start+1,i);
                start=i+1;
                continue;
            }
        }
        return ans;
    }
}