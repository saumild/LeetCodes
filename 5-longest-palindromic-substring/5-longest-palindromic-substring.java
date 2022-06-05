class Solution {
    public String longestPalindrome(String s) {
        if(s.isEmpty() || s.equals(""))
            return "";
        int dp[][] = new int[s.length()+1][s.length()+1];
        int max = 1,left = 0,right = 0;
        for(int i = 0; i< s.length();i++){
            dp[i][i] = 1;
        }
        
        for(int i = 0; i< s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                left = i;
                right = i+1;
                dp[i][i+1] = 1;
                max = 2;
            }else
                dp[i][i+1] = 0;
        }
        
        for(int k = 3; k<= s.length();k++){
            for(int i =0 ;i< s.length() - k + 1;i++){
                int j = i+k-1;
                //System.out.println(s.charAt(i) +" " + s.charAt(j));
                //System.out.println(dp[i+1][j-1] + " " + i + " " + j);
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    if(j-i+1 > max){
                        max = j-i+1;
                        left = i;
                        right = j;
                    }
                    
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        
        
        return s.substring(left,right+1);
    }
}