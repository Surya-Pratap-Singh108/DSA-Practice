class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length)
            return -1;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            start = Math.min(start, day);
            end = Math.max(end, day);
        }

        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (isSatisfy(bloomDay, m, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean isSatisfy(int[] bloomDay, int m, int k, int day) {

        int flowers = 0;
        int bouquets = 0;

        for (int bloom : bloomDay) {

            if (bloom <= day) {
                flowers++;          // consecutive bloomed flowers
            } else {
                bouquets += flowers / k;
                flowers = 0;
            }

            if (bouquets >= m)
                return true;
        }

        // Count the last consecutive block
        bouquets += flowers / k;

        return bouquets >= m;
    }
}