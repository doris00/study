package leetcode;

import java.util.Random;
import java.util.Scanner;

/**
 * 考察排序算法
 * 1、堆排序
 * 2、快速排序
 */
public class KthLargestElement {
    private static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
    }
    //快排
    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }
    public static int quickSort(int[] nums, int i, int j, int k) {
        if(i >= j) {
            return nums[i];
        }
        int x = nums[(i + j) / 2];
        int l = i, r = j;
        while(l < r) {
            while(nums[l] > x) {
                l++;
            }
            while (nums[r] < x) {
                r--;
            }
            if(l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        int lc = l - i + 1;
        if(lc >= k) {
            return quickSort(nums, i, l, k);
        }
        return  quickSort(nums, l + 1, j, k - lc);
    }
}
