/*Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int ans[] = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i< nums.length ;i++){
            left *= nums[i-1];
            ans[i] = left;
        }
        for(int j = nums.length-2 ;j>=0;j--){
            right *= nums[j + 1];
            ans[j] *= right;
        }
        return ans;
    }
}

