package day5;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间(hard)
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class class2 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length==0)
                return new int[0][2];
            //排序更具左节点升序排列 使用排序
//            Arrays.sort(, new Comparator<Object>() {
//            });
            Arrays.sort(intervals,new Comparator<int[]>(){
                @Override
                public int compare(int[] intervals1,int[] intervals2) {
                   return intervals1[0] -intervals2[0];
                }
            });
            //声明返回值merged
            List<int[]> merged=new ArrayList<int[]>();
            for (int i=0;i<intervals.length;i++){
                int left=intervals[i][0],right=intervals[i][1];
                //list索引是从0开始计数的
                if(merged.size()==0||merged.get(merged.size()-1)[1]<left){
                    merged.add(new int[]{left,right});
                }
                else{
                    merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],right);
                }
            }
            //用toArray将List对象转化成对应的数组对象！！！！
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
