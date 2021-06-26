/*
    1. Transpose the matrix
    2. reflect the matrix
    TC- O(N) - N is number of elements
    SC- O(1)
*/
class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        
        //transpose
        for(int i = 0; i<N;i++){
            for(int j = i; j<N;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //reflection
        for(int i = 0; i<N;i++){
            for(int j = 0; j<N/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-j-1];
                matrix[i][N-j-1] = temp;
            }
        }
    }
}

/*
TC- O(N) - N is number of elements
SC- O(1)
*/ 
class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}