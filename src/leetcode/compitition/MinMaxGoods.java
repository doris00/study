package leetcode.compitition;


import java.util.Scanner;

/**
 * 给你一个整数n，表示有n间零售商店。总共有m种产品，每种产品的数目用一个下标从 0 开始的整数数组quantities表示，其中quantities[i]表示第i种商品的数目。
 *
 * 你需要将 所有商品分配到零售商店，并遵守这些规则：
 *
 * 一间商店 至多只能有 一种商品 ，但一间商店拥有的商品数目可以为任意件。
 * 分配后，每间商店都会被分配一定数目的商品（可能为 0件）。用x表示所有商店中分配商品数目的最大值，你希望 x越小越好。也就是说，你想 最小化分配给任意商店商品数目的 最大值。
 * 请你返回最小的可能的x。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimized-maximum-of-products-distributed-to-any-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinMaxGoods {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] qualities = new int[m];
        for (int i = 0; i < m; ++i) {
            qualities[i] = sc.nextInt();
        }
        System.out.println(minimizedMaximum(n, qualities));
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int hi = 0;
        int low = 0;
        for(int v : quantities) {
            if (v > hi) {
                hi = v;
            }
            low += v;
        }
        low = (low + n - 1) / n;
        while (low <= hi) {
            int mid = (low + hi) / 2;
            if(canDistribute(n, quantities, mid)) {
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean canDistribute(int n, int[] q, int k) {
        for (int v : q) {
            int x = (v + k - 1) / k;//取上整
            n -= x;
            if(n < 0) {
                return false;
            }
        }
        return true;
    }
}
