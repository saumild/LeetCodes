class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        List<int[]> res = new ArrayList<>();
        
        for(int[] p : people){
            res.add(p[1],p);
        }
        return res.toArray(new int[people.length][2]);
    }
}