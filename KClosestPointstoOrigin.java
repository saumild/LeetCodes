class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        if (points == null || points.length == 0) return new int[0][0];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]) );
            
        // Now load each set of points on to the minHead
        for (int i = 0; i < points.length; i++) {
            minHeap.offer(points[i]);
        }
        
        // Next we create an array to contain points up to K
        int[][] results = new int[k][2];
        
        // Then iterate and add elements from our minHeap up to K
        for (int i = 0; i < k; i++) {
            results[i] = minHeap.poll();
        }
        
        return results;
    }
}