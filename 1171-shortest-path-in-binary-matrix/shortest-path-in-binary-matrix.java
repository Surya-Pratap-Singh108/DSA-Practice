class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)return -1;
        Queue<int[]> q=new ArrayDeque<>();
        int[][]ans=new int[grid.length][grid.length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[0][0]=1;
        grid[0][0] = 1;
        //8 directions
        int a[]={-1,-1,-1,0,1,1,1,0};
        int b[]={-1,0,1,1,1,0,-1,-1};
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[]curr=q.poll();
                for(int j=0;j<8;j++){
                    int newR=curr[0]+a[j];
                    int newC=curr[1]+b[j];
                    if(newR<0||newR==grid.length||newC<0||newC==grid.length||grid[newR][newC]!=0)continue;
                    grid[newR][newC]=1;
                    ans[newR][newC] = ans[curr[0]][curr[1]] + 1;
                    q.offer(new int[]{newR,newC});
                }
                
            }
        }
        return ans[grid.length-1][grid.length-1]!=Integer.MAX_VALUE?ans[grid.length-1][grid.length-1]:-1;
    }
}