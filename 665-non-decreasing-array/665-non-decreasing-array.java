class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean modified = false;
        int len = nums.length;
        
        for(int idx=0;idx<len-1;idx++){
            if(nums[idx]>nums[idx+1]){
                if(modified) return false;
                
                modified = true;
                if(idx-1>=0&&nums[idx+1]<nums[idx-1]){
                    idx++;
                    if(idx+1<len&&nums[idx+1]<nums[idx-1]) return false; 
                }
                
            }
        }
        
        
        return true;
    }
}