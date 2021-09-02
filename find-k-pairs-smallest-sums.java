/**Simple elegant solution */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1] + b[0]-a[1] -a[0]);
        for(int num : nums1){
            for(int num2: nums2){
                maxHeap.add(new int[]{num,num2});
                
                if(maxHeap.size()>k){
                    maxHeap.poll();
                }
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        while(maxHeap.size()>0){
            int[] pair = maxHeap.poll(); 
            List<Integer> ls = new ArrayList<>();
            ls.add(pair[0]);
            ls.add(pair[1]);
            result.add(ls);
        }
        return result;
    }
}



/**Improved solution */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->(a[0]+a[1]-(b[0]+b[1])));
                                                         
        for(int i=0;i<nums1.length && i<k;i++)
        {
            minHeap.offer(new int[]{nums1[i],nums2[0],0});
        }
        List<List<Integer>> res=new ArrayList<>();
        
        while(k!=0 && !minHeap.isEmpty())
        {
            int []cur=minHeap.poll();
            List<Integer> sub=new ArrayList<>();
            sub.add(cur[0]);
            sub.add(cur[1]);
            res.add(sub);
            k--;
            if(cur[2] == nums2.length-1)continue;
            minHeap.offer(new int[]{cur[0],nums2[cur[2]+1],cur[2]+1});
        }
        return res;
        
    }
       
}

class Solution {
    
    int[][] dirs = {{0,1},{1,0},{1,1}};
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        // EDGE CASE
        if(nums1==null || nums2==null || nums1.length==0 || nums2.length==0) return result;
        
        // visited array
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        
        // Min Heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return  ( a[0]+a[1] ) - ( b[0]+b[1] ) ;
        });
        
        
        int[] temp = new int[]{nums1[0],nums2[0],0,0};
        pq.add(temp);
        visited[0][0]= true;
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            List<Integer> ls = new ArrayList<>();
            ls.add(arr[0]);ls.add(arr[1]);
            result.add(ls);
            
            if(result.size()==k) break;
            int i=arr[2],j=arr[3];
            
            for(int[] dir : dirs){
                int dx=i+dir[0],dy=j+dir[1];
                if(dx<0 || dx>=nums1.length || dy<0 || dy>=nums2.length || visited[dx][dy]) continue;
                pq.add(new int[]{nums1[dx],nums2[dy],dx,dy});   
                visited[dx][dy] = true;
            }
        }
        
        return result;
        
        
    }
}