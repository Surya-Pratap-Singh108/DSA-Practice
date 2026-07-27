class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Step 1: Pair and sort projects by capital requirement
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];  // capital first for sorting
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> a[0] - b[0]); // sort by min capital

        // Step 2: Max-heap on profit (only affordable projects live here)
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());

        int idx = 0;
        for (int i = 0; i < k; i++) {
            // Unlock all projects we can now afford
            while (idx < n && projects[idx][0] <= w) {
                maxProfit.offer(projects[idx][1]);
                idx++;
            }
            // No affordable project available
            if (maxProfit.isEmpty()) break;

            // Pick the most profitable one
            w += maxProfit.poll();
        }
        return w;
    }
}