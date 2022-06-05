class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return wordRec(s,wordDict,0,dp);
        
    }
    
    public boolean wordRec(String s, List<String> wordDict, int start,Boolean[] dp){
        int end = s.length();
        if(start == s.length())
                return true;
        if(dp[start] != null){
            return dp[start];
        }
        for(int i = start+1;i<=end;i++){
            
            if(wordDict.contains(s.substring(start,i)) && wordRec(s,wordDict,i,dp)){
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}