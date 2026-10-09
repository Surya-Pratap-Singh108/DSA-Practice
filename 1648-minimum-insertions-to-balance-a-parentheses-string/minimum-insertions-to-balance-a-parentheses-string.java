class Solution {
    public int minInsertions(String s) {
        int i=0;
        int open=0;
        int ans=0;
        while(i<s.length()){
            char curr=s.charAt(i);
            if(curr=='('){
                open++;
            }
            else{
                if(i<s.length()-1&&s.charAt(i+1)==')'){
                    if(open>0)open--;
                    else ans++;
                    i++;
                }
                else{
                    if(open>0)open--;
                    else ans++;
                    ans++;
                }
            }
            i++;
        }
        return ans+2*open;
    }
}