package com.raptor.chapter.stack;

import java.util.HashMap;
import java.util.Map;

/**
 * @author raptor
 * @description T347
 * @date 2022/3/29 16:52
 */
public class T347 {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            Integer integer = map.get(nums[i]) == null ? 0 : map.get(nums[i]);
            integer++;
            if (integer > maxTime) {
                maxTime = integer;
            }
            map.put(nums[i], integer);
        }
        int[] ans = new int[k];
        int index = 0;
        while(k > 0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxTime){
                    ans[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxTime--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        int[] ints = new T347().topKFrequent(nums, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
