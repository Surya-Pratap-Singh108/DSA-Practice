class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q=new ArrayDeque<>();
        int ans=0;
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)fresh++;
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                    // grid[i][j]=0;
                }
            }
        }
        int[] a={0,1,0,-1};
        int[] b={1,0,-1,0};
        while(!q.isEmpty()&&fresh>0){
            int size=q.size();
            ans++;
            for(int i=0;i<size;i++){
                int[]curr=q.poll();
                int currR=curr[0];
                int currC=curr[1];
                for(int j=0;j<a.length;j++){
                    int newR=currR+a[j];
                    int newC=currC+b[j];
                    if(newR<0||newR==grid.length||newC<0||newC==grid[newR].length) continue;
                    if(grid[newR][newC]==1){
                        fresh--;
                        grid[newR][newC]=2;
                        q.offer(new int[]{newR,newC});
                    }
                }
                
            }
        }
        return fresh>0?-1:ans;
    }
}