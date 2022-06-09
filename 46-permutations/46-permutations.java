class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        permutation(result,curr,nums);
        return result;
    }
    public void permutation(List<List<Integer>> result, List<Integer> curr, int[] nums){
        if(curr.size() == nums.length)
            result.add(new ArrayList<>(curr));
        
        for(int i = 0; i< nums.length;i++){
            if(!curr.contains(nums[i])){
                curr.add(nums[i]);
                permutation(result,curr,nums);
                curr.remove(curr.size()-1);
            }
               // continue;
            
        }
    }
}