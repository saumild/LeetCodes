class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int[] t : edges){
            List<Integer> temp = map.getOrDefault(t[0], new ArrayList<>());
            temp.add(t[1]);
            map.put(t[0],temp);
            temp = map.getOrDefault(t[1], new ArrayList<>());
            temp.add(t[0]);
            map.put(t[1], temp);
        }
        
        for(int i : map.keySet()){
            //System.out.println(i + " " + map.get(i).size());
            if(map.containsKey(i)){
                if(map.get(i).size() == map.size()-1){
                    return i;
                }
            }
        }
        return -1;
    }
}