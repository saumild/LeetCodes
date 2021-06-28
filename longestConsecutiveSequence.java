/*
    TC- O(n)
    SC - O(1)
*/ 
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int curr = 1;
                int currNum = num;
                while(set.contains(currNum+1)){
                    currNum +=1;
                    curr +=1;
                }
                longest = Math.max(curr,longest);
            }
        }
        return longest;
    }
}