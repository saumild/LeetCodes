class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int front = 0,rear = 0;
        int maxScore = Integer.MIN_VALUE;
        for(int i = 0; i< k;i++){
            front+=cardPoints[i];
        }
        
        maxScore = Math.max(maxScore,front);
        if(k == cardPoints.length)
            return maxScore;
        
        for(int i = k;i>0;i--){
            front -= cardPoints[i-1];
            rear += cardPoints[cardPoints.length - k + i -1];
            maxScore = Math.max(maxScore,front+rear);
        }
        return maxScore;
    }
}

//1 2 3 4 5 6 1
  
