class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i< grid.length;i++){
            for(int j = 0; j< grid[0].length;j++){
                if(grid[i][j] == '1'){
                    ans++;
                    bfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    
    public void bfs(char[][] grid, int i, int j){
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        grid[i][j] = '0';
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] d : dir){
                int next_i = curr[0] + d[0];
                int next_j = curr[1] + d[1]; 
                if(next_i<0 || next_i>=grid.length || next_j < 0 || next_j >=grid[0].length || grid[next_i][next_j] == '0'){
                    continue;
                }
                grid[next_i][next_j] = '0';
                q.add(new int[]{next_i,next_j});
            }
            
            
            
        }
        
    }
}