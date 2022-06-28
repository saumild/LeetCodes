class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        HashSet<Integer> set = new HashSet<>();
        int result = 0;
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        
        for(int i = 0; i<26;i++){
            while(freq[i]>0 && set.contains(freq[i])){
                freq[i]--;
                result++;
            }
            set.add(freq[i]);
        }
        return result;
    }
}