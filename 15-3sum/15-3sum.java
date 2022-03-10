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
                twoSum(nums,ans, i);
        }
        return ans;
    }
    
    public void twoSum(int nums[], List<List<Integer>> ans, int i){
        HashSet<Integer> comp = new HashSet<>();
        
        for(int j = i+1;j<nums.length;j++){
            int complement = -nums[i] - nums[j];
            if(comp.contains(complement)){
                ans.add(Arrays.asList(nums[i],nums[j], complement));
                while(j+1<nums.length && nums[j] == nums[j+1])
                    j++;
            }
            comp.add(nums[j]);
        }
    }
}