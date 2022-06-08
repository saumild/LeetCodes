class Solution {
    public int distributeCandies(int[] candyType) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i: candyType){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        if(candyType.length/2 < map.size())
            return candyType.length/2;
        else
            return map.size();
        
    }
}