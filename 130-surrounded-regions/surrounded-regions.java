class Solution {
    public void solve(char[][] board) {
        
        boolean[][] isSafe=new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if((i==0||j==0||i==board.length-1||j==board[i].length-1)&&board[i][j]=='O'){
                    dfs(board,isSafe,i,j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j]=='O'&& !isSafe[i][j]){
                    board[i][j]='X';
                }
            }
        }
        
        
    }
    public void dfs(char[][]board,boolean[][]isSafe,int row,int column){
        if(row<0||row>=board.length||
            column<0||column>=board[row].length
            ||board[row][column]=='X'||isSafe[row][column])
        {
            return ;
        }        
        
        isSafe[row][column]=true;
        
        dfs(board,isSafe,row-1,column);
        dfs(board,isSafe,row,column+1);
        dfs(board,isSafe,row+1,column);
        dfs(board,isSafe,row,column-1);
    }
}