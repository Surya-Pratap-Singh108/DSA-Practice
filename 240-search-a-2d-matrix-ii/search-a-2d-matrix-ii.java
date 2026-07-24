class
 Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0;
        int column=matrix[0].length-1;
        while(row<matrix.length&&column>=0){
            int current=matrix[row][column];
            if(current==target)return true;
            else if(current>target) column--;
            else row++;
        }
        return false;
	}
}