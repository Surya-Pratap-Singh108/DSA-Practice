class Solution {
    public int closedIsland(int[][] grid) {
        boolean [][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if((i==0||j==0||i==grid.length-1||j==grid[i].length-1)&&(grid[i][j]==0&&!visited[i][j])) dfs(grid,i,j,visited);
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if((grid[i][j]==0&&!visited[i][j])){
                    dfs(grid,i,j,visited);
                    ans++;
                } 
            }
        }
        return ans;
    }
    
    public void dfs(int[][]grid,int r,int c,boolean[][]visited){
        if(r<0||r>=grid.length||c<0||c>=grid[r].length||visited[r][c]||grid[r][c]==1)return;
        
        visited[r][c]=true;
        grid[r][c]=1;
        
        //up 
        dfs(grid,r-1,c,visited);
        
        //down 
        dfs(grid,r+1,c,visited);
        
        //right
        dfs(grid,r,c+1,visited);
        
        //left 
        dfs(grid,r,c-1,visited);
    }
}