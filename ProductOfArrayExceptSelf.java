/* O(n^2) - TC solution */
class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] ans  = new int[nums.length];
        for(int i = 0; i<nums.length; i++){
            product*=nums[i];
        }
        for(int i = 0; i< nums.length;i++){
            int temp = product;
            if(nums[i] != 0)
                ans[i] = product/nums[i];
            else{
                int prod = 1;
                for(int j = 0; j<nums.length;j++){
                    if(j != i)
                        prod*=nums[j];
                }
                ans[i] = prod;
            }
                
        }
        return ans;
    }
}

/*Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right
O(n) -TC and O(1) - SC */
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int[] ans  = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i<nums.length; i++){
            left *= nums[i-1];
            ans[i] = left;
        }
        for(int i = nums.length-2; i>= 0;i--){
            right *= nums[i+1];
            ans[i] *= right;
        }
        return ans;
    }
}


