package day6;

/**
 * 搜索二维矩阵 II(middle)
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class class4 {
    //从右上角看就是一棵二叉搜索树
    //但是我不会二叉树，就暴力解答了
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            for(int x:matrix[i])
                if(x==target)
                    return true;
        }
        return false;
    }
}
