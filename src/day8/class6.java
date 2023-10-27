package day8;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层序遍历
 * 层序遍历就是从左到右一层一层遍历二叉树
 * bfs 广度优先算法
 * bfs 普遍使用队列作为数据结构
 */
public class class6 {
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
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root!=null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            //获取当前队列中有多少值，然后把这些都踢出去，然后加新的进来
            int n=queue.size();
            //使用这个来存储按照顺序遍历出来的东西
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node=queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            //他的返回值的类型是[[],[],[]] 不是[]的
            res.add(level);
        }
        return res;
    }
}
