class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums){
            //if(!pq.contains(num)){
                pq.add(num);
            //}
        }
        for(int i = 0; i< k-1;i++){
            pq.poll();
        }
        return pq.poll();
    }
}