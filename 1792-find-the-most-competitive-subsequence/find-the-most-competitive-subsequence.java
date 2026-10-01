class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while(!s.isEmpty() && s.peek() > num
                  && s.size() + (nums.length - i) > k) {
                s.pop();
            }

            if(s.size() < k) {
                s.push(num);
            }
        }

        for(int i = k - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }
}