package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Auther: hlam
 * @Date: 2023/08/21
 */
public class Solution {

    @Test
    public void testMerge() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    @Test
    public void testSummaryRanges() {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    @Test
    public void testCanChange() {
        System.out.println(canChange("_L__R__R_", "L______RR"));
    }

    /**
     * 56. 合并区间
     * medium
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int s = intervals[i][0], e = intervals[i][1];
            if (ans.get(ans.size() - 1)[1] < s) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 228. 汇总区间
     * 给定一个  无重复元素 的 有序 整数数组 nums 。
     * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
     * "a->b" ，如果 a != b
     * "a" ，如果 a == b
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0, j = 0; i < n; i = j + 1) {
            j = i;
            while (j + 1 < n && nums[j + 1] == nums[j] + 1) {
                j++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            if (i != j) {
                sb.append("->");
                sb.append(nums[j]);
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    /**
     * 2337. 移动片段得到字符串
     * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
     * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
     * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
     * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
     * <p>
     * 输入：start = "R_L_", target = "__LR"
     * 输出：false
     * 解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
     * 但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
     *
     * @param start
     * @param target
     * @return
     */
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;
        while (true) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n || start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
    }
}
