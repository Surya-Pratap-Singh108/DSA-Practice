class Solution {
    public int[][] updateMatrix(int[][] mat) {
       Queue<int[]> queue=new ArrayDeque<>();
       
       boolean[][] visited=new boolean[mat.length][mat[0].length];
       for(int i=0;i<mat.length;i++){
           for(int j=0;j<mat[i].length;j++){
               if(mat[i][j]==0 ){
                   
                    queue.offer(new int[]{i,j});
                    visited[i][j]=true;
               }  
               
           }
       }
       int[][]ans=new int[mat.length][mat[0].length];
       int[]a={0,1,0,-1};
       int[]b={1,0,-1,0};
       int level=0;
       while(!queue.isEmpty()){
           int size=queue.size();
           level++;
           for(int i=0;i<size;i++){
               int curr[]=queue.poll();
               for(int j=0;j<a.length;j++){
                   int nr=curr[0]+a[j];
                   int nc=curr[1]+b[j];
                   if(nr<0||nr>=mat.length||nc<0||nc>=mat[0].length||visited[nr][nc]){
                       continue;
                   }
                   visited[nr][nc]=true;
                    ans[nr][nc]=level;
                    queue.offer(new int[]{nr,nc});
                   

               }
           }   
       }
       return ans;
    }
}