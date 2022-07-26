/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (IsAncestor(p, q)) {
            // p is q's ancestor
            return p;
        }
        if (IsAncestor(q, p)) {
            // q is p's ancestor
            return q;
        }
        if((root.left == p ||  root.left == q) && (root.right == p ||  root.right == q))
            return root;

        
        if (IsAncestor(root.left, p) && IsAncestor(root.left, q)) {
            // p, q are both in left side
            return lowestCommonAncestor(root.left, p ,q);
        }
        if (IsAncestor(root.right, p) && IsAncestor(root.right, q)) {
            // p, q are both in right side
            return lowestCommonAncestor(root.right, p ,q);
        }
        // p, q are in different sides of the root
        return root;

    }
    private boolean IsAncestor(TreeNode ancestorCandidate, TreeNode node) {
        if (ancestorCandidate == null) {
            return false;
        }
        if (ancestorCandidate.left == node||ancestorCandidate.right == node) {
            return true;
        }

        return IsAncestor(ancestorCandidate.left, node)||IsAncestor(ancestorCandidate.right, node);
    }
}