class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int[]> queue=new ArrayDeque<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0)queue.offer(new int[]{i,j});
            }
        }
        boolean[][]visited=new boolean[matrix.length][matrix[0].length];
        while(!queue.isEmpty()){
            int[]curr=queue.poll();
            if(!visited[curr[0]][curr[1]]){
                visited[curr[0]][curr[1]]=true;
                helper(matrix,curr[0],curr[1]);
            }
        }
        
        
    }
    public void helper(int[][] matrix,int row,int col){
        for(int j=0;j<matrix[0].length;j++){
            matrix[row][j]=0;
        }
        for(int i=0;i<matrix.length;i++){
            matrix[i][col]=0;
        }
    }
}