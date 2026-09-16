class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] ans=new int[nums.length];
        for(int i=2*nums.length-2;i>=0;i--){
            int curr=i%nums.length;
            while(!stack.isEmpty()&&stack.peek()<=nums[curr]){
                stack.pop();
            }
            if(i<nums.length){
                // ans[i]=stack.isEmpty()?-1:stack.peek();
                ans[curr]=stack.isEmpty()?-1:stack.peek();
            }
            stack.push(nums[curr]);
        }
        return ans;
    }
}