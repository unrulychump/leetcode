package day8;

/**
 * 二叉树的直径
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class class5 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        class Solution {

            int res = 0;

            public int diameterOfBinaryTree(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                res = Math.max(getMaxDepth(root.left) + getMaxDepth(root.right), res);
                diameterOfBinaryTree(root.left);
                diameterOfBinaryTree(root.right);
                return res;
            }

            private int getMaxDepth(TreeNode root) {
                if (root == null) {
                    return 0;
                }
                return 1 + Math.max(getMaxDepth(root.left), getMaxDepth(root.right));
            }
        }
    }
}
