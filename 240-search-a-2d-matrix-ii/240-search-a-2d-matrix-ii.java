/* TC : O(n+m) SC: O(1)*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }
}