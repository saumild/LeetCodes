class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return s.size() != nums.length ? true: false;
    }
}