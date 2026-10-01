class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> s = new Stack<>();
        int remove = nums.length - k;

        for (int num : nums) {
            while (!s.isEmpty() && s.peek() > num && remove > 0) {
                s.pop();
                remove--;
            }

            s.push(num);
        }

        while (remove > 0) {
            s.pop();
            remove--;
        }

        int[] ans = new int[k];

        for (int i = k - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }
}