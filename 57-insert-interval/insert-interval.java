class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] < newInterval[0]) {
                // Completely before newInterval
                ans.add(intervals[i]);

            } else if (intervals[i][0] > newInterval[1]) {
                // Completely after newInterval
                ans.add(newInterval);
                newInterval = intervals[i];

            } else {
                // Overlap
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        ans.add(newInterval);

        return ans.toArray(new int[ans.size()][]);
    }
}