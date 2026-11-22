class Solution {
    public boolean checkString(String s) {
        boolean bStart=false;
       for(char ch : s.toCharArray()){
            if(ch=='b')bStart=true;
            else if(ch=='a'&&bStart)return false;

       }
       return true; 
    }
}