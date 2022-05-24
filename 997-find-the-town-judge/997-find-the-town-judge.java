class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] adjList = new int[n+1];
        if(trust.length< n-1){
            return -1;
        } 
        for(int[] t : trust){
            adjList[t[0]]--;
            adjList[t[1]]++;
        }
        for(int t= 1; t<= n;t++){
            if(adjList[t] == n-1){
                return t;
            }
        }
        return -1;
    }
}