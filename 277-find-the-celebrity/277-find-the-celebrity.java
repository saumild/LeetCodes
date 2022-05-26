/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        boolean[] isParent = new boolean[n];
        for(int i =0 ;i<n;i++) isParent[i] = true;
        for(int i = 0; i<n;i++){
            if(!isParent[i]) continue;
            for(int j = 0;j<n;j++){
                if(i == j) continue;
                if(knows(i,j) || !knows(j,i)){
                    isParent[i] = false;
                }
            }
        }
        for(int i =0;i<n;i++){
            if(isParent[i] == true)
                return i;
        }
        return -1;
    }
    
}