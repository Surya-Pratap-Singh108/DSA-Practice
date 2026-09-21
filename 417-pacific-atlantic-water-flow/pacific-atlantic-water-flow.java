class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length; 
        int n=heights[0].length; 
        boolean[][]pacific=new boolean[m][n];
        boolean[][]atlantic=new boolean[m][n];
        
        //pacific for left boundry
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }
        //pacific for top boundry
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
        }

        // Atlantic for right boundry
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }
        // Atlantic for bottom boundry
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            
                if(pacific[i][j]&&atlantic[i][j]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
                
            }
            
        }
        
        return ans;
    }
    
    public void dfs(int[][]heights,int r,int c,boolean[][]visited){
        if(visited[r][c])return;
        
        visited[r][c]=true;
        
        int[] a={-1,0,1,0};
        int[] b={0,1,0,-1};
        
        for(int i=0;i<4;i++){
            int nr=r+a[i];
            int nc=c+b[i];
            
            if(nr<0||nr>=heights.length||nc<0||nc>=heights[0].length)continue;
            
            if(heights[nr][nc]>=heights[r][c]){
                dfs(heights,nr,nc,visited);
            }
        }
    }
}