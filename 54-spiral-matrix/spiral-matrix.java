class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom) {

            // left -> right
            for (int i = left; i < right; i++) {
                ans.add(matrix[top][i]);
            }

            // Only one row is left
            if (top == bottom) {
                ans.add(matrix[top][right]);
                break;
            }

            // top -> bottom
            for (int i = top; i < bottom; i++) {
                ans.add(matrix[i][right]);
            }

            // Only one column is left
            if (left == right) {
                ans.add(matrix[bottom][right]);
                break;
            }

            // right -> left
            for (int i = right; i > left; i--) {
                ans.add(matrix[bottom][i]);
            }

            // bottom -> top
            for (int i = bottom; i > top; i--) {
                ans.add(matrix[i][left]);
            }

            top++;
            right--;
            bottom--;
            left++;
        }

        return ans;
    }
}