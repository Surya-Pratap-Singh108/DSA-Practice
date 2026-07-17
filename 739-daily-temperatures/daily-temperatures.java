class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans=new int[temperatures.length];
        
        for(int i=temperatures.length-1;i>=0;i--){
            int curr=temperatures[i];
            
            while(!stack.isEmpty()&&curr>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i]=stack.peek()-i;
            }
            stack.push(i);
       }
       return ans;
    }
}