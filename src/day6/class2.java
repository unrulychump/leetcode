package day6;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵(middle)
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，
 * 返回矩阵中的所有元素。
 */
public class class2 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int i=0,j=0;
            List<Integer> list=new ArrayList<>();
            Boolean flag=false;
            while(true){
                if(flag){
                    //如果flag=true,那么继续向上走
                    if(i!=0&&matrix[i-1][j]!=101){
                        list.add(matrix[i][j]);
                        matrix[i--][j]=101;
                        continue;
                    }
                }
                //向右走
                if(j!=matrix[i].length-1&&matrix[i][j+1]!=101){
                    list.add(matrix[i][j]);
                    matrix[i][j++]=101;
                    flag=false;
                    continue;
                }
                //向下走
                if(i!=matrix.length-1&&matrix[i+1][j]!=101){
                    list.add(matrix[i][j]);
                    matrix[i++][j]=101;
                    flag=false;
                    continue;
                }
                //向左走
                if(j!=0&&matrix[i][j-1]!=101){
                    list.add(matrix[i][j]);
                    matrix[i][j--]=101;
                    flag=false;
                    continue;
                }
                //向上走
                if(i!=0&&matrix[i-1][j]!=101){
                    list.add(matrix[i][j]);
                    matrix[i--][j]=101;
                    flag=true;
                    continue;
                }
                //四个方向都走不了表示到了终点
                list.add(matrix[i][j]);
                break;
            }
            return list;
        }
    }
}
