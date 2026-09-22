class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        s1=new String(chars);
        
        for(int i=s1.length();i<=s2.length();i++){
            String temp1=s2.substring(i-s1.length(),i);
            char[] temp2=temp1.toCharArray();
            Arrays.sort(temp2);
            temp1=new String(temp2);
            if(s1.equals(temp1))return true;
        }
        return false;
    }
}
