/*
    TC - O(N^2*logK)
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for(int i = 0; i< matrix.length;i++){
            for(int j = 0; j<matrix[0].length;j++){
                maxHeap.add(matrix[i][j]);
                if(maxHeap.size()>k){
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}

/**TC - O(min(K,N)+K∗logN).
 * Sc- O(N)
 */
class Solution {

    public int kthSmallest(int[][] matrix, int k) {
      PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
  
      // put the 1st element of each row in the min heap
      // we don't need to push more than 'k' elements in the heap
      for (int i = 0; i < matrix.length && i < k; i++)
          minHeap.add(new Node(i, 0));
  
      // take the smallest (top) element form the min heap, if the running count is equal to k return the number
      // if the row of the top element has more elements, add the next element to the heap
      int numberCount = 0, result = 0;
      while (!minHeap.isEmpty()) {
        Node node = minHeap.poll();
        result = matrix[node.row][node.col];
        if (++numberCount == k)
          break;
        node.col++;
        if (matrix[0].length > node.col)
          minHeap.add(node);
      }
      return result;
    }
  }
  class Node {
    int row;
    int col;
  
    Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  



//BST
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int count = 0; 
            int j = n - 1;
            for (int i = 0; i < m; i++) {
                while (j >= 0 && matrix[i][j] > mid)
                    j--;
                count += j + 1;
            }
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
}