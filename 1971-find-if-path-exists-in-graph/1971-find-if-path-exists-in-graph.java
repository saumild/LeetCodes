class Solution {
    int[] parent;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n+1];
        
        for(int i = 0; i< n; i++ ){
            parent[i] = i;
        }
        for(int[] e: edges){
            int p1 = findParent(e[0]);
            int p2 = findParent(e[1]);
            
            if(p1 != p2){
               parent[p2] = p1; 
            }
        }
        return findParent(source) == findParent(destination);
    }
    
    public int findParent(int u){
        return (parent[u] == u)?u : (parent[u] = findParent(parent[u]));
        
    }
}