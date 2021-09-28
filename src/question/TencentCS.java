package question;

import java.util.Scanner;

/**
 * 画匠问题
 * 给定一个整型数组，数组中每个值都为正数，表示完成一幅画需要的时间，给一个整数k表示画匠的数量
 * 每个画匠只能画连在一起的画作，所有的画家并行工作，返回完成所有工作所需的最短时间
 * arr = [3,1,4],k = 2;
 * 输出：4
 * 采用二分法来做
 */
public class TencentCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getTime(arr, k));
    }
    public static long getTime(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k < 1) {
            throw new RuntimeException("输入参数有误");
        }
        if(arr.length < k) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; ++i) {
                max = Math.max(max, arr[i]);
            }
            return max;
        } else {
            long minSum = 0;
            long maxSum = 0;
            for (int i = 0; i < arr.length; ++i) {
                maxSum += arr[i];
            }
            while (minSum != maxSum - 1) {
                long mid = (maxSum + minSum) / 2;
                if(getParts(arr, mid) > k) {
                    minSum = mid;
                } else {
                    maxSum = mid;
                }
            }
            return maxSum;
        }
    }
    public static int getParts(int[] arr, long lim) {
        int res = 1;
        long stepSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > lim) {
                return Integer.MAX_VALUE;
            }
            stepSum += arr[i];
            if (stepSum > lim) {
                res++;
                stepSum = arr[i];
            }
        }
        return res;
    }
}
