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
        
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        
        int ans = 0;
        for(int i = 0; i< s.length();i++){
            if(i+1<s.length() && map.containsKey(Character.toString(s.charAt(i)) + Character.toString(s.charAt(i+1)) + "")){
                //System.out.println("inside");
                ans += map.get(Character.toString(s.charAt(i)) + Character.toString(s.charAt(i+1)));
                i++;
                continue;
            }
            if(map.containsKey(s.charAt(i) + ""))
                ans += map.get(s.charAt(i) + "");
            //System.out.println(ans);
        }
        return ans;
    }
}