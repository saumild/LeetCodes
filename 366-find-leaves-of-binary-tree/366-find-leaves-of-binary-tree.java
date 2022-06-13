/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int maxHeight = -1;
    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i<=maxHeight;i++){
            res.add(map.get(i));
        }
        return res;
    }
    
    public int getHeight(TreeNode root){
        if(root == null)
            return -1;
        
        int height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        List<Integer> ls = map.getOrDefault(height,new ArrayList<>());
        ls.add(root.val);
        map.put(height, ls);
        
        if(maxHeight<height){
            maxHeight = height;
        }
        return height;
    }
    
    
}