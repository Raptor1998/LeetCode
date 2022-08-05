package com.enternal.greddy;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/7/23  10:10
 */
public class CanComplete {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int nowgas = gas[i];
            if (nowgas == 0){
                continue;
            }
            int nowcost = cost[i];
            int nowpos = i;
            while (nowgas>=nowcost){
                nowgas-=nowcost;
                ++nowpos;
                nowpos = nowpos == n ? 0:nowpos;
                nowgas+=gas[nowpos];
                nowcost = cost[nowpos];
                if (nowpos == i){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new CanComplete().canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
    }
}
