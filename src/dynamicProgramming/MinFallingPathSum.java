package dynamicProgramming;

import org.junit.Test;

/**
 * @Description: 1289. 下降路径最小和 II
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * @Auther: hlam
 * @Date: 2023/08/10
 */
public class MinFallingPathSum {

    /**
     * 1572. 矩阵对角线元素的和
     * 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
     * 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
     * 输入：mat = [[1,2,3],
     *             [4,5,6],
     *             [7,8,9]]
     * 输出：25
     * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
     * 请注意，元素 mat[1][1] = 5 只会被计算一次。
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            int j = n - i - 1;
            ans += mat[i][i] + (i == j ? 0 : mat[i][j]);
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] grid = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(grid));
        System.out.println(diagonalSum(grid));
    }

    public int minFallingPathSum(int[][] grid) {
        int f = 0, g = 0;
        int fp = -1;
        final int inf = 1 << 30;
        for (int[] row : grid) {
            int ff = inf, gg = inf;
            int ffp = -1;
            for (int i = 0; i < row.length; i++) {
                int s = (i != fp ? f : g) + row[i];
                if (s < ff) {
                    gg = ff;
                    ff = s;
                    ffp = i;
                } else if (s < gg) {
                    gg = s;
                }
            }
            f = ff;
            g = gg;
            fp = ffp;
        }
        return f;
    }

}
