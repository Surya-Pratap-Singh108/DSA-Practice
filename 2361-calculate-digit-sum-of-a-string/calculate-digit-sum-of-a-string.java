class Solution {
    public String digitSum(String s, int k) {
        
        while(s.length()>k){
            int totalL=s.length();
            String temp="";
            for(int i=0;i<totalL;i+=k){
                int currSum=0;
                for(int j=i;j<totalL&&k>j-i;j++){
                    currSum=currSum+(s.charAt(j)-'0');
                }
                temp=temp+currSum;
            }
            s=temp;
        }
        
        return s;
    }
}