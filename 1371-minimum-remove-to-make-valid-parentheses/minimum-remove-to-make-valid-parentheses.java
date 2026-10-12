class Solution {
    public String minRemoveToMakeValid(String s) {
       StringBuilder ans=new StringBuilder();
       int open=0;
       for(int right=0;right<s.length();right++){
           char curr=s.charAt(right);
           if(curr=='(')open++;
           else if(curr==')'){
               if(open==0){
                   continue;
               }
               open--;
           }
          ans.append(curr);
       }
       for(int i=ans.length()-1;i>=0&&open>0;i--){
           if(ans.charAt(i)=='('){
               open--;
               ans.deleteCharAt(i);
           }
       }
       return ans.toString();
    }
}