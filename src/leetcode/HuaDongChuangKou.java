package leetcode;

import java.util.Scanner;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HuaDongChuangKou {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] res = maxSlidingWindow(nums, k);
        for(int e : res) {
            System.out.print(e + " ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(k <= 1) {
            return nums;
        }
        int[] maxs = new int[n - k + 1];
        int maxIndex = 0;
        for(int i = 1; i < k; ++i) {
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for(int begin = 0; begin < maxs.length; ++begin) {
            int end = begin + k - 1;
            if(nums[end] > nums[maxIndex]) {
                maxIndex = end;
            } else if(maxIndex < begin) {
                maxIndex = begin;
                for(int i = begin + 1; i <= end; ++i) {
                    if(nums[i] > nums[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }
            maxs[begin] = nums[maxIndex];
        }
        return maxs;
    }
}
