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
        HashMap<Integer,Integer> parent = new HashMap<>();
        parent.put(0,-1);
        Stack<Integer> s = new Stack<>();
        
        s.push(0);
        while(!s.isEmpty()){
            int curr = s.pop();
            for(int nei : adj.get(curr)){
                if(parent.get(curr) == nei){
                    continue;
                }
                if(parent.containsKey(nei)){
                   return false; 
                }
                s.push(nei);
                parent.put(nei,curr);
            }
        }
        return parent.size() == n;
    }
}