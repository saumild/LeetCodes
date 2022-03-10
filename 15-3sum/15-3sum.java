class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // n^3 solution 
        //fix 2 numbers and check for 3rd number
        //to fastern the search we can put values in hashmap..
        //store the sum of 2 values in hashmap and then find the third value by iterating in the array
        //make sure to put the not equal condition
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length<3)
            return new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length && nums[i]<= 0;i++){
            if(i == 0 || nums[i-1] != nums[i])
                twoSum2(nums,ans, i);
        }
        return ans;
    }
    
    public void twoSum2(int nums[], List<List<Integer>> ans, int i){
        int l = i+1,r = nums.length-1;
        while(l<r){
            int sum = nums[i] + nums[l] + nums[r];
            if(sum<0){
                ++l;
            }else if(sum > 0){
                --r;
            }else{
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;r--;
                while(l<r && nums[l] == nums[l-1])
                    ++l;
            }
        }
    }
}