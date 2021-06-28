 
class Solution {
    public int firstMissingPositive(int[] nums) {
        int ans = -1;
        int max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i =0 ;i<nums.length;i++){
            if(nums[i]> 0 && nums[i]<nums.length+1){
                if(nums[i]>max){
                    max = nums[i];
                }
                set.add(nums[i]);
            }
        }
        for(int i =1 ;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max>0?max+1:1;
    }
}


class Solution2 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while( i < nums.length){
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums,i,nums[i] - 1);
            }else{
                i++;
            }
        }
        for(i = 0;i<nums.length;i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
