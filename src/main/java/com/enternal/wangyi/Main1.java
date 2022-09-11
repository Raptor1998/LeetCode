package com.enternal.wangyi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/4  14:23
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] nums = new int[n];
            int max = 0;
            HashMap<Integer,Integer>  map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                nums[i]=scanner.nextInt();
                int mod = nums[i] % k;
                Integer integer = map.get(mod);
                if (integer == null){
                    integer = 1;
                    map.put(mod,integer);
                    max = Math.max(integer,max);
                }else {
                    integer++;
                    map.put(mod,integer);
                    max = Math.max(integer,max);
                }
            }
            System.out.println(max);

        }

    }
}
