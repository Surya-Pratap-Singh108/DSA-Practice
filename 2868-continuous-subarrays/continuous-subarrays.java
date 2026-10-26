import java.util.*;

class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();

        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain increasing order for minimum
            while (!minDeque.isEmpty() &&
                   nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Maintain decreasing order for maximum
            while (!maxDeque.isEmpty() &&
                   nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Shrink the window while it is invalid
            while ((long) nums[maxDeque.peekFirst()]
                         - nums[minDeque.peekFirst()] > 2) {

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                left++;
            }

            // Count valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}