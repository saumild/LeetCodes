class Solution {
    public int romanToInt(String s) {
        //creating mapping in HashMap
        //create mapping for 6 cases 4,9, 40, 90, 400, 900
        //parse the string and calculate the integer
        
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        
        String lastSymbol = s.substring(s.length() - 1);
        int lastValue = map.get(lastSymbol);
        int total = lastValue;

        for (int i = s.length() - 2; i >= 0; i--) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = map.get(currentSymbol);
            if (currentValue < lastValue) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
            lastValue = currentValue;
        }
        return total;
    }
}