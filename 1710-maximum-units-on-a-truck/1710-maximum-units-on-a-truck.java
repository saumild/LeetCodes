class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
       PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]- a[1]);
       
        int ans = 0;
        pq.addAll(Arrays.asList(boxTypes));
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int boxCount = Math.min(curr[0],truckSize);
            //System.out.print(boxTypes[i][1]*boxCount + " ");
            ans += curr[1]*boxCount;
            truckSize = truckSize - boxCount;

        }
        return ans;
    }
}