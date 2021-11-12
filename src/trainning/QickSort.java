package trainning;

public class QickSort {
    public static void quickSort(int[] nums, int i, int j) {
        int pivot = 0;
        int pivotIndex = findPivot(nums, i, j);
        if(pivotIndex != -1) {
            pivot = nums[pivotIndex];
            int k = partition(nums, i, j, pivot);
            quickSort(nums, k, j);
            quickSort(nums, i, k - 1);
        }
    }
    public static int partition(int[] nums, int i, int j, int pivot) {
        int l = i, r = j;
        while(l <= r) {
            while(l <= j && nums[l] < pivot) {
                ++l;
            }
            while(r >= i && nums[r] >= pivot) {
                --r;
            }
            if(l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return l;
    }
    //pivot等于最先找到的两个不同关键字中的最大者，如果没有不同关键字返回-1
    public static int findPivot(int[] nums, int i, int j) {
        int first = nums[i];
        for(int k = i + 1; k <= j; ++k) {
            if(nums[i] < nums[k]) {
                return k;
            } else if(nums[i] > nums[k]) {
                return i;
            }
        }
        return -1;
    }
}
