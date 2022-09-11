package com.enternal.jd;

import java.io.PipedWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author 陈文豪(chenwenhao.0401 @ bytedance.com)
 * @version 1.0
 * @created 2022/9/9  10:42
 */
public class Main2 {
    static long mod = 1000000000 + 7;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long[] nums = new long[n];
            long le = 0;
            long ri = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextLong();
                if (nums[i] % 2 == 0) {
                    ri++;
                } else {
                    le++;
                }
            }
            long ans = 0;
            if (le >= 2){
//                long pow1 = ppow(2, le) - le - 1;
//                ans += pow1;
                BigInteger bigInteger = new BigInteger(String.valueOf(2));
                BigInteger bigInteger1 = bigInteger.modPow(new BigInteger(String.valueOf(le)), BigInteger.valueOf(mod));
                ans += bigInteger1.intValue();
                ans = ans - le - 1;
            }
            if (ri >= 2){
//                long pow2 = ppow(2, ri) - ri - 1;
//                ans+=pow2;
                BigInteger bigInteger = new BigInteger(String.valueOf(2));
                BigInteger bigInteger1 = bigInteger.modPow(new BigInteger(String.valueOf(ri)), BigInteger.valueOf(mod));
                ans += bigInteger1.intValue();
                ans = ans - ri - 1;
            }
            System.out.println(ans);
        }
    }

    public static long ppow(long a,long b){
        long res = 1;
        while (b!=0){
            if ((b&1) == 1){
                res = res * a % mod;
            }
            BigInteger bigInteger = new BigInteger(String.valueOf(a));
            bigInteger = bigInteger.multiply(bigInteger);
            a = a * a % mod;
            b = b >> 1;
        }
        return res % mod;
    }

}
