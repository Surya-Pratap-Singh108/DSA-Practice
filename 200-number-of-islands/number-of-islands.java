class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    helper(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void helper(char[][]grid,boolean[][]visited,int r,int c){
        if(r<0||r>=grid.length||c<0||c>=grid[r].length||visited[r][c]||grid[r][c]=='0') return;
        
        visited[r][c]=true;
        
        helper(grid,visited,r-1,c);
        helper(grid,visited,r+1,c);
        helper(grid,visited,r,c-1);
        helper(grid,visited,r,c+1);
        
    }
}