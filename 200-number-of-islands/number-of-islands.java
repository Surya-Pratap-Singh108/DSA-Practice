class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(!visited[i][j]&&grid[i][j]=='1'){
                   dfs(grid,visited,i,j);
                   ans++;
                   
                }
            }
        }

        return ans;
        
	}
	
	public void dfs(char[][] grid,boolean[][] visited,int r,int c){
	    if(r<0||r>=grid.length||c<0||c>=grid[r].length||grid[r][c]=='0'||visited[r][c]){
	        return;
	    }
	    visited[r][c]=true;
	    
	    //up
	    dfs(grid,visited,r-1,c);
	    //down
	    dfs(grid,visited,r+1,c);
	    //left
	    dfs(grid,visited,r,c-1);
	    //right
	    dfs(grid,visited,r,c+1);
	    
	}
}