package leetcode.compitition;

import java.util.*;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
 *
 * 整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
 *
 * 如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
 *
 * x + nums[i]
 * x - nums[i]
 * x ^ nums[i]（按位异或 XOR）
 * 注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
 *
 * 返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。
 * 1 <= nums.length <= 1000
 * -10^9 <= nums[i], goal <= 10^9
 * 0 <= start <= 1000
 * start != goal
 * nums 中的所有整数互不相同
 */
public class ConvertToTarget5916 {
    public static int minimumOperations(int[] nums, int start, int goal) {
        boolean[] visited = new boolean[1001];
        Deque<Integer> deque = new ArrayDeque<>(Set.of(start));
        for (int i = 0; !deque.isEmpty(); i++) {
            for (int j = deque.size(); j > 0; j--) {
                int poll = deque.poll();
                if (poll == goal) {
                    return i;
                } else if (poll >= 0 && poll <= 1000 && !visited[poll]) {
                    visited[poll] = true;
                    for (int num : nums) {
                        deque.offer(poll + num);
                        deque.offer(poll - num);
                        deque.offer(poll ^ num);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        int start = sc.nextInt();
        int goal = sc.nextInt();
        System.out.println(minimumOperations(nums, start, goal));
    }
}
