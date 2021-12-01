package com.raptor.random;

import org.junit.Test;

/**
 * @author raptor
 * @description TargetSum_494
 * @date 2021/6/7 19:51
 */
public class TargetSum_494 {

    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    /**
     *
     * @DESC 数组长度小且只存在加和减两种情况，最容易想到的就是暴力搜索
     *
     * @param nums  初始数组
     * @param target  目标值
     * @param index  当前索引
     * @return  总和
     */
    public int dfs(int[] nums, int target, int index) {
        if (nums.length == index) {
            if (target == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return dfs(nums, target + nums[index], index + 1) + dfs(nums, target - nums[index], index + 1);
    }

    public void dp(int[] nums, int target){

    }



    @Test
    public void context() {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums,target));
    }
}

/*
* 给你一个整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加'+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。


示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1

提示：

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/target-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

