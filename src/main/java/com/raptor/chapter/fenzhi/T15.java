package com.raptor.chapter.fenzhi;

import java.util.*;

/**
 * @author raptor
 * @description T15
 * @date 2022/4/6 16:25
 */
public class T15 {

    class Triple {
        int x;
        int y;
        int z;

        public Triple() {
        }

        public Triple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Triple triple = (Triple) o;
            return x == triple.x && y == triple.y && z == triple.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        HashSet<Triple> set = new HashSet<>();
        int n = nums.length;
        if (n < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                //已经排序   > 0 直接返回
                if (nums[i] > 0) {
                    break;
                }
                //重复
                if (i > 0 && nums[i] == nums[i - 1]) {
                    break;
                }
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    Triple triple = new Triple(nums[i], nums[left], nums[right]);
                    if (!set.contains(triple)) {
                        set.add(triple);
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                    }
                    left++;
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> list = new T15().threeSum(nums);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
