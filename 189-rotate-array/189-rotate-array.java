class Solution {
    public void rotate(int[] nums, int k) {
        int temp[] = new int[nums.length];
        int n =nums.length;
        if(k>=n)
            k = k%n;
        for(int i=0;i< k;i++){
            temp[i] = nums[n-k+i];
        }
        
        for(int i = k; i< nums.length;i++){
            temp[i] = nums[i-k];
        }
        
        for(int i =0 ;i< nums.length;i++){
            nums[i] = temp[i];
        }
    }
}