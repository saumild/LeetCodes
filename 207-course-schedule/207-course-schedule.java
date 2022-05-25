class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(prerequisites == null || numCourses == 0 || prerequisites.length ==0)
            return true;
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int i = 0 ; i< numCourses;i++){
            adj.put(i,new LinkedList<Integer>());
        }
        
        for(int[] req: prerequisites){
            adj.get(req[0]).add(req[1]);
            indegree[req[1]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
            
        for(int i = 0; i< numCourses;i++){
            if(indegree[i] == 0)
                queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int t: adj.get(curr)){
                indegree[t]--;
                if(indegree[t] == 0)
                    queue.add(t);
            }
            count++;
            
        }
        return count == numCourses;
                
    }
    
}