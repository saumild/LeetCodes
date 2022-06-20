class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int left = 0;
        int right = 0;
        for(int i = 1,j = nums.length -2; i< nums.length;i++){
            leftSum[i] = left + nums[i-1];
            left = leftSum[i];
            rightSum[j] = right + nums[j+1];
            right = rightSum[j];
            j--;
        }
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;
        
        for(int i =0 ;i < leftSum.length;i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}