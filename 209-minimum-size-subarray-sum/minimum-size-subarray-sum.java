class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int low = 0;
        int high = 0;
        int current_sum = 0;
        int min_length = Integer.MAX_VALUE;

        while (high < arr.length) {
            current_sum += arr[high];

            while (current_sum >= target) {
                min_length = Math.min(min_length, high - low + 1);
                current_sum -= arr[low];
                low++;
            }

            high++;
        }

        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
}
