class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(adjList, visited, pathVisited, i)) {
                    return false; 
                }
            }
        }
        return true; 
    }
    public boolean dfs(List<List<Integer>> adjList,
                       boolean[] visited,
                       boolean[] pathVisited,
                       int curr) {

        visited[curr] = true;
        pathVisited[curr] = true;

        for (int neighbor : adjList.get(curr)) {

            if (!visited[neighbor]) {

                if (dfs(adjList, visited, pathVisited, neighbor)) {
                    return true;
                }

            } else if (pathVisited[neighbor]) {
                return true; 
            }
        }

        pathVisited[curr] = false;

        return false;
    }
}