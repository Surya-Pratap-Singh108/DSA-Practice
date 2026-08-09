class Solution {
    public int orangesRotting(int[][] grid) {

        int fresh = 0;
        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return time;

        while (!queue.isEmpty() && fresh > 0) {

            time++;
            int size = queue.size();

            while (size > 0) {

                int[] curr = queue.poll();

                // go up
                if (curr[0] - 1 >= 0 &&
                    grid[curr[0] - 1][curr[1]] == 1) {

                    grid[curr[0] - 1][curr[1]] = 2;
                    fresh--;
                    queue.offer(new int[]{curr[0] - 1, curr[1]});
                }

                // go down
                if (curr[0] + 1 < grid.length &&
                    grid[curr[0] + 1][curr[1]] == 1) {

                    grid[curr[0] + 1][curr[1]] = 2;
                    fresh--;
                    queue.offer(new int[]{curr[0] + 1, curr[1]});
                }

                // go left
                if (curr[1] - 1 >= 0 &&
                    grid[curr[0]][curr[1] - 1] == 1) {

                    grid[curr[0]][curr[1] - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{curr[0], curr[1] - 1});
                }

                // go right
                if (curr[1] + 1 < grid[0].length &&
                    grid[curr[0]][curr[1] + 1] == 1) {

                    grid[curr[0]][curr[1] + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{curr[0], curr[1] + 1});
                }

                size--;
            }
        }

        return fresh == 0 ? time : -1;
    }
}