package question;

import java.util.Scanner;

public class WeiZhong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] nums = new int[m][n];//阻力值
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        String s = sc.next();//获取指令
        char[] order = s.toCharArray();
        int ans = 0;
        int a = 0, b = 0;//初始位置
        for(int i = 0; i < order.length; ++i) {

            switch (order[i]) {
                case 'h'://向左
                    if(b - 1 < 0 || nums[a][b - 1] == -1) {
                        ans += y;
                    }
                    if(i != 0 && order[i - 1] != order[i]) {
                        ans += x;
                    }
                    if(b - 1 >= 0 && nums[a][b - 1] != -1) {
                        ans += Math.max(nums[a][b], nums[a][--b]);
                    }
                    break;
                case 'j'://向下
                    if(a + 1 >= m || nums[a + 1][b] == -1) {
                        ans += y;
                    }
                    if(i != 0 && order[i - 1] != order[i]) {
                        ans += x;
                    }
                    if(a + 1 < n && nums[a + 1][b] != -1) {
                        ans += Math.max(nums[a][b], nums[++a][b]);
                    }
                    break;
                case 'k':
                    if(a - 1 < 0 || nums[a - 1][b] == -1) {
                        ans += y;
                    }
                    if(i != 0 && order[i - 1] != order[i]) {
                        ans += x;
                    }
                    if(a - 1 >= 0 && nums[a - 1][b] != -1) {
                        ans += Math.max(nums[a][b], nums[--a][b]);
                    }
                    break;
                case 'l':
                    if(b + 1 >= n || nums[a][b + 1] == -1) {
                        ans += y;
                    }
                    if(i != 0 && order[i - 1] != order[i]) {
                        ans += x;
                    }
                    if(b + 1 < m && nums[a][b + 1] != -1) {
                        ans += Math.max(nums[a][b], nums[a][++b]);
                    }
                    break;
            }
        }
        System.out.println(ans);
    }
}
