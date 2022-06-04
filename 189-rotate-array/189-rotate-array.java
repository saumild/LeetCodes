class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        if(k > n)
            k = k%n;
        reverse(nums,0, n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0, n-1);
    }
    
    public void reverse(int[] nums, int s, int e){
        
        while(s<e){
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;e--;
        }
    }
}
/*
divide array, 
reverse 1st and 2nd part
reverse the whole array
1 2 3 4 5
k = 2
123-> 321
45 -> 54
32154 -> 45123 => soln
*/
