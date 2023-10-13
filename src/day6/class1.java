package day6;
//矩阵题目

/**
 * 矩阵置零(middle)
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
 * 请使用 原地 算法。
 *
 * 出现在最外围的时候是不能判断是原生的0还是后面添加的0，所以要在最后的时候附上外围的0
 */
public class class1 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            //m行数，n列数
            int m = matrix.length, n = matrix[0].length;

            //声明两个标记tag表示是不是改了行列
            boolean flagCol0 = false, flagRow0 = false;
            for (int i = 0; i < m; i++) {
                if (matrix[i][0] == 0) {
                    flagCol0 = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0) {
                    flagRow0 = true;
                }
            }

            //先给最外围的补上0
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
            //根据外围的结果补上十字架的0
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            //最外面的一层最后处理
            //如果原先有0的话，就吧对应的行列赋0
            if (flagCol0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][0] = 0;
                }
            }
            if (flagRow0) {
                for (int j = 0; j < n; j++) {
                    matrix[0][j] = 0;
                }
            }
        }
    }
}
