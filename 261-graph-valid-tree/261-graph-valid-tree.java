class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i =0; i<n;i++) adj.put(i, new ArrayList<>());
        for(int[] e: edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> s = new Stack<>();
        visited.add(0);
        s.push(0);
        while(!s.isEmpty()){
            int curr = s.pop();
            for(int nei : adj.get(curr)){
                if(!visited.contains(nei)){
                    s.push(nei);
                    visited.add(nei);    
                }else{
                    continue;
                }
            }
        }
        return visited.size() == n;
    }
}