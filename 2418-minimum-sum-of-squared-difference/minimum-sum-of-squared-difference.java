import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            totalDiff += diff[i];
        }

        long k = (long) k1 + k2;

        if (k >= totalDiff) {
            return 0;
        }

        Arrays.sort(diff);

        for (int i = n - 1; i >= 0; i--) {
            long count = n - i;
            long next = (i == 0) ? 0 : diff[i - 1];

            // Operations needed to lower this group to the next level
            long needed = ((long) diff[i] - next) * count;

            if (k >= needed) {
                k -= needed;
            } else {
                // Distribute remaining operations among this group
                long reduce = k / count;
                long remaining = k % count;
                long level = diff[i] - reduce;

                long ans = 0;

                // Differences before this group remain unchanged
                for (int j = 0; j < i; j++) {
                    ans += (long) diff[j] * diff[j];
                }

                // Most elements reach the same level
                ans += (count - remaining) * level * level;

                // Remaining elements are reduced one extra time
                ans += remaining * (level - 1) * (level - 1);

                return ans;
            }
        }

        return 0;
    }
}