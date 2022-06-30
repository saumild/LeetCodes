class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int pivot = nums[nums.length/2];
        int res = 0;
        int l = 0,r = nums.length-1;
        while(l<r){
            res += nums[r] - nums[l];
            l++;r--;
        }
        return res;
    }
}

//median