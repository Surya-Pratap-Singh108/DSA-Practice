class Solution {
    public int longestValidParentheses(String s) {
        int open=0;
        int close=0;
        int length=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')open++;
            else close++;
            
            if(open==close){
                length=Math.max(length,open+close);
            }
            else if(close>open){
                open=0;
                close=0;
            }
        }
        open=0;
        close=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(')open++;
            else close++;
            
            if(open==close){
                length=Math.max(length,open+close);
            }
            else if(open>close){
                open=0;
                close=0;
            }
        }
        return length;
    }
}