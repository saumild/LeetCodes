/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    private int numberOfPeople;
    
    public int findCelebrity(int n) {
        numberOfPeople = n;
        int cel = 0;
        for (int i = 0; i < n; i++) {
            if (knows(cel,i)) {
                cel = i;
            }
        }
        if(isCelebrity(cel)){
            return cel;
        }
        return -1;
    }
    
    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
    
}