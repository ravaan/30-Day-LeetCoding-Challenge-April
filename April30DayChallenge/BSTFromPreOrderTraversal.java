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
    public TreeNode bstFromPreorder(int[] pre) {
        ArrayList<Integer> smaller = new ArrayList<>();
        ArrayList<Integer> greater = new ArrayList<>();
        int root_val = pre[0];
        for(int i = 1; i < pre.length; i++){
            if(pre[i] > root_val) greater.add(pre[i]);
            else smaller.add(pre[i]);
        }
        int [] small = new int[smaller.size()];
        int [] big = new int[greater.size()];
        for(int i = 0; i < small.length; i++) small[i] = smaller.get(i);
        for(int i = 0; i < big.length; i++) big[i] = greater.get(i);

        TreeNode root = new TreeNode(root_val);
        if(small.length < 1) root.left = null;
        else root.left = bstFromPreorder(small);
        if(big.length < 1) root.right = null;
        else root.right = bstFromPreorder(big);
        return root;
    }
}
