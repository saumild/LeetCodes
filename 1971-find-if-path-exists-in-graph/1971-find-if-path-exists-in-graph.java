class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // if(source == destination)
        //     return false;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) map.put(i, new ArrayList());
        for(int[] i : edges){
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }
        
        // for(Map.Entry<Integer,List<Integer>> m : map.entrySet()){
        //     System.out.println(m.getKey() + " [" + m.getValue() + "]");
        // }
        
        Stack<Integer> s = new Stack<>();
        boolean[] v = new boolean[n];
        s.add(source);
        
        while(!s.isEmpty()){
            int curr = s.pop();
            v[curr] = true;
            
            if(curr == destination)
                return true;
            //List<Integer> next = map.get(curr);
            //int i = 0;
            for(int next : map.get(curr)){
               // System.out.println(next);
                //System.out.println(next.get(i));
                if(!v[next]){
                    if(next == destination)
                        return true;
                    s.push(next);
                }
                
            }
        }
        
        return false;
    }
}

// Run DFS over source node and see if you can reach dest.
// Another approach can be to find connected components and see if source and dest are in same connected component(DSU or union find)