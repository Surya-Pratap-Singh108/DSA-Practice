class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree=new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            adjList.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> q=new ArrayDeque<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        List<Integer> processed=new LinkedList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            processed.add(curr);
            for(int neighbor:adjList.get(curr)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0)q.offer(neighbor);
            }
        }
        
        return processed.size()==numCourses;
    }
}