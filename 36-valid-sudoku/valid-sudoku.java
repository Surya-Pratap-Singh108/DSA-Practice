class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] != '.'&& !isSafe(board,i,j)) return false;
            }
        }
        return true;
    }
    public boolean isSafe(char[][] board,int r,int c){
        for(int i=0;i<board.length;i++){
            if(i==r)continue;
            if(board[i][c]==board[r][c])return false;
        }
        for(int j=0;j<board[0].length;j++){
            if(j==c)continue;
            if(board[r][j]==board[r][c])return false;
        }
         int sqrt = 3;
        int startR = r - r % sqrt;
        int startC = c - c % sqrt;
        for (int i = startR; i < startR + sqrt; i++) {
            for (int j = startC; j < startC + sqrt; j++) {
                if (i == r && j == c) continue;
                if (board[i][j] == board[r][c]) return false;
            }
        }
        
        return true;
    }
}