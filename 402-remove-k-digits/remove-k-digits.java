class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()<=k)return "0";
        Stack<Character> stack = new Stack<>();

        for (char ch:num.toCharArray()) {
            
            while(k>0&&!stack.isEmpty()&&stack.peek()>ch){
                stack.pop();
                k--;
            }
        
            stack.push(ch);
            
            
        }
        while(k>0){
            stack.pop();
            k--;
        }
        boolean flag=false;
        StringBuilder ans=new StringBuilder();
        for(char ch:stack){
            if(ch!='0'){
                flag=true;
            }
            if(flag){
                ans.append(ch);
            }
        }
        if(ans.length()==0)return "0";
        return ans.toString();
            
          
    }
}