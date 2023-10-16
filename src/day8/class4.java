package day8;

/**
 * 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class class4 {
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

        public boolean isSymmetric(TreeNode root) {
            //讲道理将两个二叉树的前序和中序输出然后判断
            //等等 好像这样太麻烦了 题解里面也是可以用递归解决的
            //总是会设计空的问题 md
            if(root==null)
                return false;
            return dfs(root.left,root.right);
        }
        boolean dfs(TreeNode left,TreeNode right){
            //只有到最后的时候才是对的
            if(left==null && right==null)
                return true;
            if(left ==null || right==null)
                return false;
            if(left.val!=right.val)
                return false;
            //使用and符号作为返回值 就成功解决问题了
            return dfs(left.left,right.right)&&dfs(left.right,right.left);
        }
    }
}
//使用的是dfs算法
/**
 * 深度优先算法
 * 选择一个起始节点或顶点，将其标记为已访问。
 * 探索从当前节点出发的所有未访问的相邻节点。
 * 选择一个相邻节点，将其标记为已访问，并将其设为新的当前节点。
 * 重复步骤2和步骤3，直到无法再继续前进。
 * 当无法前进时，回溯到上一个节点，检查是否还有未访问的相邻节点。
 * 重复步骤4和步骤5，直到遍历完成。
 *
 */
