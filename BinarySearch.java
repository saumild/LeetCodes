class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int index = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else 
                right = mid-1;
        }
        return -1;
    }
    
}


class Solution1 {
    public int search(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length);
    }
    
    public int binarySearch(int[] nums, int target, int left, int right){
        int index = -1;
        if(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target)
                index = mid;
            else if(nums[mid]>target)
                return binarySearch(nums,target,left,mid-1);
            else
                return binarySearch(nums,target,mid+1,right);
        }
        return index;
        
    }
}