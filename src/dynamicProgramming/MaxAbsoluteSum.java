package dynamicProgramming;

import org.junit.Test;

/**
 * @Description: 1749.任意子数组和的绝对值的最大值
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * abs(x) 定义如下：
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 * @Auther: hlam
 * @Date: 2023/08/08
 */
public class MaxAbsoluteSum {

    @Test
    public void test() {
        System.out.println(1 << 30);
    }

    @Test
    public void maxAbsoluteSum() {
        int[] nums = {1, -3, 2, 3, -4};
        int f = 0, g = 0, ans = 0;
        for (int i : nums) {
            f = Math.max(f, 0) + i;
            g = Math.min(g, 0) + i;
            ans = Math.max(ans, Math.max(f, Math.abs(g)));
        }
        System.out.println(ans);
    }
}
