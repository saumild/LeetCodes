class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        Queue<Integer> q = new PriorityQueue<>();
        
        for(int i =0 ;i<heights.length-1;i++){
            int jump = heights[i+1] -heights[i];
            if(jump <= 0)
                continue;
            q.add(jump);
            if(q.size()<= ladders)
                continue;

            bricks -= q.remove();

            if(bricks<0)
                return i;

        }
        
     return heights.length - 1;   
        
    }
}