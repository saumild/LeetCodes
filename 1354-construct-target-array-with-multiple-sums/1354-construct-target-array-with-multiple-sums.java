class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        int totalSum = Arrays.stream(target).sum();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : target)
            maxHeap.add(num);
        //System.out.println(maxHeap.peek());
        while(maxHeap.element()>1){
            int largest = maxHeap.remove();
            if (totalSum-largest == 1) {
                return true;
            }
            int newVal = largest % (totalSum-largest);
            
            if(newVal ==0 || newVal ==largest)
                return false;
            maxHeap.add(newVal);
            totalSum = totalSum - largest + newVal;
        }
        return true;
    }
}