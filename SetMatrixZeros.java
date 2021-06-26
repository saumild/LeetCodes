/*
    TC - O(n^2)
    SC- O(n) - worstcase
*/ 
class Solution1 {
    public void setZeroes(int[][] matrix) {
        List<Pair<Integer,Integer>> ls =new ArrayList<>();
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0 ;j< matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    Pair<Integer,Integer> ps = new Pair<>(i,j);
                    ls.add(ps);
                }
            }
        }
        for(Pair p : ls){
            int i = (int)p.getKey();
            int j = (int)p.getValue();
            for(int k = 0; k< matrix.length;k++){
                matrix[k][j] = 0;
            }
            for(int k = 0; k< matrix[0].length;k++){
                matrix[i][k] = 0;
            }
        }
    }
}

/*
    TC - O(n^2)
    SC- O(1) - worstcase
*/ 
class Solution2 {
    public void setZeroes(int[][] matrix) {
        //List<Pair<Integer,Integer>> ls =new ArrayList<>();
        boolean isCol = false;
        
        for(int i = 0; i<matrix.length; i++){
            if(matrix[i][0] == 0)
                isCol = true;
            for(int j = 1 ;j< matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i< matrix.length;i++){
            for(int j = 1; j< matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }    
        }
        
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(isCol){
            for(int i = 0; i< matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}
