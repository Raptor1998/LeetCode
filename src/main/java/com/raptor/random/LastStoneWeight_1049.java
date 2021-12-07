package com.raptor.random;



import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author raptor
 * @description LastStoneWeight_1049
 * @date 2021/6/8 20:05
 */
public class LastStoneWeight_1049 {
    public int lastStoneWeightII(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }
        Arrays.sort(stones);
        int last = 0,i;
        for (i = 1; i < stones.length; i++) {
            stones[i - 1] = stones[i] - stones[i - 1];
        }
        for(int j:stones){
            System.out.println(j);
        }
        return last;
    }

    @Test
    public void context() {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        lastStoneWeightII(stones);
    }
}
