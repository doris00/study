package trainning;

import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        heapSort(nums);
        for (int num: nums) {
            System.out.println(num);
        }
    }
    public static void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 1; --i) {//初始建堆，从最右非叶子节点开始
            putDown(nums, i - 1, n);//整理堆，以i-1为根，最小标的叶为n-1
        }
        for (int i = n - 1; i >= 1; --i) {
            swap(nums, 0, i);//堆顶与当前堆中的下标最大的叶节点交换
            putDown(nums, 0, i);//整理堆，以0为根，最大下标的叶为i-1
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 该操作的功能是把以nums[first]为根，以nums[last]为最后一个结点的完全二元树整理成堆。
     * 它要完成的功能是，把完全二叉树中的关键字最小的元素放到堆顶，而把原堆顶元素下推到适当的位置，使(A[first],…,A[last])成为堆。
     * @param nums
     * @param first
     * @param last
     */
    private static void putDown(int[] nums, int first, int last) {
        int r = first;
        while (r <= last / 2 - 1) {
            if((r == last / 2 - 1) && (last % 2) == 0) {
                //r有一个儿子在2 * r,且为左儿子
                if (nums[r] < nums[2 * r + 1]) {
                    swap(nums, r, 2 * r + 1);//下推
                }
                r = last;//循环结束
            } else if(nums[r] < nums[2 * r + 1] && nums[2 * r + 1] >= nums[2 * r + 2]) {
                //根大于左儿子，且左儿子小于或等于右儿子
                swap(nums, r, 2 * r + 1);//与左儿子交换
                r = 2 * r + 1;//下推到的位置
            } else if(nums[r] < nums[2 * r + 2] && nums[2 * r + 2] > nums[2 * r + 1]) {
                //根大于右儿子，且右儿子小于左儿子
                swap(nums, r, 2 * r + 2);//与右儿子交换
                r = 2 * r + 2;//下推到的位置，也是下次考虑的根
            } else {//nums[r]符合堆的定义，不用整理
                r = last;
            }
        }
    }

}
