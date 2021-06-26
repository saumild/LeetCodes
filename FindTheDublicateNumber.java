/*O(n) - TC and O(1) -SC */
class Solution1 {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i<nums.length ;i++){
            int index = nums[i]>0?nums[i]:nums[i]*-1;
            if(nums[index] < 0)
                return index;
            nums[index] *= -1;
        }
        return 0;
    }
}

/*O(n) - TC and O(1) -SC 
    Cycle Detection algorithm
    Floyd's Tortoise and Hare (Cycle Detection)
*/
class Solution2 {
    public int findDuplicate(int[] nums) {
      // Find the intersection point of the two runners.
      int tortoise = nums[0];
      int hare = nums[0];
      do {
        tortoise = nums[tortoise];
        hare = nums[nums[hare]];
      } while (tortoise != hare);
  
      // Find the "entrance" to the cycle.
      tortoise = nums[0];
      while (tortoise != hare) {
        tortoise = nums[tortoise];
        hare = nums[hare];
      }
  
      return hare;
    }
  }

/*O(n) - TC and O(1) -SC 
    Cyclic sort algorithm
    In-place sorting algorithm and is unstable
*/
class Solution3 {
    public int findDuplicate_CyclicSortWay(int[] nums) {
         int i = 0;
         while (i < nums.length) {
             if (nums[i] != nums[nums[i]]) swap(nums, i, nums[i]);
             else i++;
         }
         return nums[0];
     }
     
     public void swap(int[] arr, int i, int j) {
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
     }
 }