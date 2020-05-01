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
    public ArrayList<Integer> getDia(TreeNode root) {
        //First elem is diameter,second elem is depth
        if(root == null) {
            return new ArrayList<>(Arrays.asList(0,0));
        }
        ArrayList<Integer> left = getDia(root.left);
        ArrayList<Integer> right = getDia(root.right);
        ArrayList<Integer> dia = new ArrayList<Integer>();
        int temp = Math.max(left.get(0),right.get(0));
        dia.add(Math.max(temp,left.get(1) + right.get(1)));
        dia.add(Math.max(left.get(1),right.get(1)) + 1);
        return dia;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        return getDia(root).get(0);
    }
}