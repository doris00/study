package question;

public class Microsoft1 {
    public static void main (String[] args) {
        // Scanner sc = new Scanner(System.in);
        int m = 4;
        int n = 6;
        char k = 1;
        int[][] nums = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                nums[i][j] = k++;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(nums[i][j] <= 9) {
                    System.out.print(" " + nums[i][j] + " ");
                } else {
                    System.out.print(nums[i][j] + " ");
                }
            }
            System.out.println();
        }
        print(nums);

    }
    public static void print(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int sum = m * n;
        int count = 0;
        int l = 0, r = n - 1;
        int top = 0, bottom = m - 1;
        int i = l;
        while (true) {
            while (i <= r) {
                System.out.print(nums[top][i] + " ");
                i++;
                count++;
            }
            if (count == sum) {
                break;
            }
            top++;
            i = top;
            while (i <= bottom) {
                System.out.print(nums[i][r] + " ");
                i++;
                count++;
            }
            if (count == sum) {
                break;
            }
            r--;
            i = r;
            while (i >= l) {
                System.out.print(nums[bottom][i] + " ");
                i--;
                count++;
            }
            if (count == sum) {
                break;
            }
            bottom--;
            i = bottom;
            while (i >= top) {
                System.out.print(nums[i][l] + " ");
                i--;
                count++;
            }
            if (count == sum) {
                break;
            }
            l++;
            i = l;
        }
    }



// Your last Java code is saved below:
// [[1, 2, 3],
// [4, 5, 6],
// [7, 8, 9]]



}
