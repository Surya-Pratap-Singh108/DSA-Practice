class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q=new ArrayDeque<>();
        
        boolean[][]visited=new boolean[grid.length][grid[0].length];
        boolean flag=false;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,q,visited,i,j);
                    flag=true;
                    break;
                }
            }
            
            if(flag)break;
            
        }
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int ans=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[]curr=q.poll();
                for(int j=0;j<dr.length;j++){
                    int r=curr[0]+dr[j];
                    int c=curr[1]+dc[j];
                    if(r==grid.length||r<0||c<0||c==grid[0].length||visited[r][c])continue;
                    if(grid[r][c]==1){
                        return ans;
                    }
                    visited[r][c]=true;
                    q.offer(new int[]{r,c});
                }
            }
            ans++;
        }
        return ans;
    }
    public void dfs(int[][] grid,Queue<int[]> q,boolean[][]visited,int r,int c){
        if(r==grid.length||r<0||c<0||c==grid[0].length||grid[r][c]==0||visited[r][c])return;
        
        visited[r][c]=true;
        q.offer(new int[]{r,c});
        
        dfs(grid,q,visited,r-1,c);
        dfs(grid,q,visited,r,c+1);
        dfs(grid,q,visited,r+1,c);
        dfs(grid,q,visited,r,c-1);
    }
}