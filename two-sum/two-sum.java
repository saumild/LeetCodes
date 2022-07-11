class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*[2,7,11,15]
        map[2-0,7-found] =? return map.get(comp),i
        */
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i< nums.length;i++){
            int compl = target - nums[i];
            if(map.containsKey(compl)){
               return new int[]{map.get(compl),i}; 
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
    
}