class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        HashMap<Integer, List<Integer>> adjList =  new HashMap<>();
        int[] in_degree =  new int[numCourses];
        for(int i = 0; i< prerequisites.length;i++){
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> list = adjList.getOrDefault(src,new ArrayList<Integer>());
            list.add(dest);
            adjList.put(src,list);
            in_degree[dest] += 1; 
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] topological_ordering = new int[numCourses];
        for(int i =0; i< numCourses;i++){
            if(in_degree[i] == 0)
                q.add(i);
        }
        int i = 0;
        while(!q.isEmpty()){
            int curr_c = q.poll();
            
            topological_ordering[i++] = curr_c;
            
            if(adjList.containsKey(curr_c)){
                for(int next : adjList.get(curr_c)){
                    in_degree[next]--;
                    if(in_degree[next] == 0){
                        q.add(next);
                    }
                }
                
            }
        }
        
        if(i == numCourses)
            return topological_ordering;
        return new int[]{};
    }
}