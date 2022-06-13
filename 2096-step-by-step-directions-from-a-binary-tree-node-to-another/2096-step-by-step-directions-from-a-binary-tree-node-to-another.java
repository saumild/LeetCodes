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
    List<String> paths;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null)
            return "";
        paths = new ArrayList<>();
        
        TreeNode lca = findLCA(root,startValue,destValue);
        getPath(lca,startValue, new StringBuilder());
        getPath(lca,destValue, new StringBuilder());
        
        StringBuilder res = new StringBuilder();
        
        for(int i = 0; i< paths.get(0).length();i++){
            res.append("U");
        }
        res.append(paths.get(1));
        
        return res.toString();
    }
    
    public TreeNode findLCA(TreeNode node, int startValue, int destValue){
        if(node == null)
            return null;
        
        if(node.val == startValue || node.val == destValue)
            return node;
        
        TreeNode left = findLCA(node.left, startValue,destValue);
        TreeNode right = findLCA(node.right, startValue,destValue);
        
        if(left != null && right != null)
            return node;
        
        return left != null? left:right;
    }
    
    public void getPath(TreeNode root, int val, StringBuilder path){
        if(root == null){
            return ;
        }
        
        if(root.val == val){
            paths.add(path.toString());
            return;
        }
        
        if(root.left != null)
            getPath(root.left, val,path.append("L"));
        
        if(root.right != null)
            getPath(root.right, val, path.append("R"));
        
        path.deleteCharAt(path.length()-1);
        return;
    }
    
    
}

/*
1. Find LCA
2. Find path from LCA to startVal
3. Find path from LCA to end
4. traverse left path and do all "U"
5. append right path;
*/