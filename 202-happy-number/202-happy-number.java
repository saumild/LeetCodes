class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = checkHappy(n);
        while(true){
            sum = checkHappy(sum);
            if(sum == 1){
                return true;
            }
            if(set.contains(sum))
                return false;
            set.add(sum);    
        }
       // return false;
    }
    
    public int checkHappy(int n){
        ArrayList<Integer> num = getDigits(n);
        int sum = 0;
        
        for(int i : num){
            sum += i*i;
        }
        return sum;
    }
    
    public ArrayList<Integer> getDigits(int n){
        ArrayList<Integer> num = new ArrayList<>();
        while (n > 0) {
            num.add(n % 10);
            n = n / 10;
        }
        return num;
    }
}
/*
1. start breaking and squaring numbers
2. store the sum into set
3. if that number occurs again its a cycle and it is not happy number
4. else if sum = 1 then its a happy number
*/