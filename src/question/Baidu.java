package question;

import java.util.Scanner;

/**
 * 放大像素
 * 索引转换
 */
public class Baidu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] data = new int[N][N];
        int[][] ans = new int[N * K][N * K];
        for(int i = 0;i < N; i++){
            for(int j = 0; j < N; j++){
                data[i][j]=scanner.nextInt();
                if(data[i][j] == 1){
                    for(int z = i * K; z < i * K + K; z++){
                        for(int y = j * K; y< j * K + K; y++){
                            ans[z][y]=1;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < N * K; ++i) {
            for(int j = 0; j < N * K; ++j) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}