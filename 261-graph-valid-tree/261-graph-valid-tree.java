class Solution {
    private int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        parent = new int[n];
        
        for (int node = 0; node < n; node++) {
            parent[node] = node;
        }
        for(int[] e: edges){
            if(!union(e[0],e[1])){
                return false;
            }
        }
        return true;
    }
    
    public boolean union(int a,int b){
        int ra = find(a);
        int rb = find(b);
        
        if(ra != rb) parent[ra] = rb;
        return ra == rb? false: true;
    }
    
    public int find(int a){
        return parent[a] == a ? a: find(parent[a]);
    }
}