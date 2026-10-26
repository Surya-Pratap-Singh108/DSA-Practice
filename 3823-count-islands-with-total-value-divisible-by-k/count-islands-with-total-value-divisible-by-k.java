class Solution {
    public int countIslands(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    long val=dfs(grid,i,j);
                    if(val%k==0) count++;
                }
            }
        }
        return count;
    }
    public long dfs(int[][] grid,int r,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[r].length||grid[r][c]==0)return 0;
        int val=grid[r][c];
        grid[r][c]=0;
        return val+dfs(grid,r-1,c)+dfs(grid,r+1,c)+dfs(grid,r,c-1)+dfs(grid,r,c+1);
    }
}