/**
 * Diameter of Binary Tree
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 */
public class _543 {
    int maxLength;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            maxLength = 0;
            countMaxLength(root);
            return maxLength;
        }
    }

    public int countMaxLength(TreeNode node) {
        if (node == null) {
            return -1;
        } else if (node.left == null && node.right == null) {
            return 0;
        } else {
            int leftDepth = this.countMaxLength(node.left) + 1;
            int rightDepth = this.countMaxLength(node.right) + 1;
            maxLength = max(maxLength, leftDepth + rightDepth);
            return max(leftDepth, rightDepth);
        }
    }

    public int max(int a, int b) {
        return a >= b ? a : b;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}