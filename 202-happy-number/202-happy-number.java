class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int sum = getDigitsSum(n);
        while(sum != 1 && !set.contains(sum)){
            set.add(sum);
            sum = getDigitsSum(sum);
        }
        return sum == 1;
    }
    
    public int getDigitsSum(int n){
        ArrayList<Integer> num = new ArrayList<>();
        int sum = 0;
        while (n > 0) {
            int x = n % 10;
            sum += x*x;
            n = n / 10;
        }
        return sum;
    }
}
/*
1. start breaking and squaring numbers
2. store the sum into set
3. if that number occurs again its a cycle and it is not happy number
4. else if sum = 1 then its a happy number
*/