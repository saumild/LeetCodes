class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        for(int j = 0; j< s.length();j++){
            if(map.containsKey(s.charAt(j))){
               i = Math.max(map.get(s.charAt(j)),i); 
            }
            maxLen = Math.max(maxLen, j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return maxLen;
    }
}
