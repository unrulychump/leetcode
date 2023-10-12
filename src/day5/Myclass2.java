package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Myclass2 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length==0)
                return new int[0][2];
            //对区间进行排序，使用Arrays.sort
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] intervals1, int[] intervals2) {
                    //现根据左节点判断，相同的时候根据右边界判断
                    if(intervals1[0]!=intervals2[0])
                        return intervals1[0]-intervals2[0];
                    else
                        return intervals1[1]-intervals2[1];
                }
            });
            //声明List变量用于操作
            List<int[]> merged=new ArrayList<>();
            for(int i=0;i< intervals.length;i++){
                //获得当前的左右边界然后判断怎么操作
                int left=intervals[i][0],right=intervals[i][1];
                //不存在的时候
                if(merged.size()==0){
                    merged.add(new int[]{left,right});
                }
                //两个区间断开的时候
                else if(merged.get(merged.size()-1)[1]<left){
                    merged.add(new int[]{left,right});
                }
                //两个区间有合并的可能的时候
                else {
                    merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],right);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
