class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs ={{0,1},{1, 0},{0,-1},{-1,0}};
        boolean[][][] visited = new boolean[m][n][k+1];
        
        q.add(new int[]{0,0,0,0});
        
        int dist = 0;
       
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            if(curr[0] == m-1 && curr[1] == n-1)
                return curr[3];
            
            if(visited[curr[0]][curr[1]][curr[2]])
                    continue;
            
            visited[curr[0]][curr[1]][curr[2]] = true;
            
            for(int[] d : dirs){
                int nextx = curr[0]+d[0];
                int nexty = curr[1] + d[1];
                int obs = curr[2];
                
                if(nextx<0 || nexty<0 || nextx>=m || nexty>=n)
                    continue;
                
                //if no obs
                if(grid[nextx][nexty] == 0 && !visited[nextx][nexty][obs]   ){
                    q.add(new int[]{nextx,nexty, obs,curr[3] + 1});
                    //visited[nextx][nexty][obs] = true;
                    continue;
                }//else if obs
                if(obs < k && !visited[nextx][nexty][obs+1]){
                    q.add(new int[]{nextx,nexty, obs+1, curr[3] + 1});
                    //visited[nextx][nexty][obs +1] = true;
                }
            }
           // dist++;
        }
        return -1;
        
        
    }
}