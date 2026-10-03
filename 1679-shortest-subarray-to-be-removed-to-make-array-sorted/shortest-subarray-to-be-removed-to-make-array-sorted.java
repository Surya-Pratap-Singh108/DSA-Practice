class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        Deque<Integer> stack = new ArrayDeque<>();

        // sorted prefix
        stack.push(0);

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                stack.push(i);
            } else {
                break;
            }
        }

        if (stack.peek() == n - 1) {
            return 0;
        }

        int ans = n - stack.size();

        int j = n - 1;

        while (true) {

            // Remove prefix elements that cannot connect
            while (!stack.isEmpty() && arr[stack.peek()] > arr[j]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans = Math.min(ans, j - stack.peek() - 1);
            } else {
                ans = Math.min(ans, j);
            }

            // suffix is no longer sorted
            if (j == 0 || arr[j - 1] > arr[j]) {
                break;
            }

            j--;
        }

        return ans;
    }
}