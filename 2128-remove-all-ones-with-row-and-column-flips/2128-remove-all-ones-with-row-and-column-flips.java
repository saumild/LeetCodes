class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i =0; i< grid[0].length;i++){
            if(grid[0][i] == 1){
                flipColumn(i, grid);
            }
        }
        
        boolean res = true;
        for(int i =1; i<grid.length;i++){
            int temp = grid[i][0];
            for(int j = 0; j<grid[0].length;j++){
                if(grid[i][j] != temp){
                    res = false;
                    break;
                }
            }
        }
        
        return res;
    }
    
    public void flipColumn(int i,int[][] grid){
        for(int j = 0; j< grid.length;j++){
            grid[j][i] = grid[j][i] == 1 ? 0 : 1;    
        }
    }
}