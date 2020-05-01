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
    int len;
    int[] a;
    boolean ans;
    public boolean isValidSequence(TreeNode root, int[] arr) {
        len = arr.length;
        a = arr;
        return helper(root, 0);
    }
    public boolean helper(TreeNode node, int i){
        if(node == null) return false;
        if(node.val != a[i]) return false;
        if(i == len - 1 && node.right == null && node.left == null) return true;
        if(i == len -1) return false;
        ans = helper(node.left, i+1) || helper(node.right, i+1);
        return ans;
    }
}