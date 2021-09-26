package question;
/**
 * n * n网络，分布了障碍物 *， 房子 #， 路.
 * 超市可以安排在 房子和路上
 * 要求每个房子都有可达的超市
 * 现在求分布超市最少，房子到超市距离之和的最少值
 */
import java.util.Scanner;

/**
 * 求最大的跳跃得分数
 * 超时 66.67%
 */
public class Tencent2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; ++t) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; ++i) {
                nums[i] = sc.nextInt();
            }
            int ans = 0;
            for(int i = 0; i < N; ++i) {
                int temp = nums[i];
                int idex = i + nums[i];
                while (idex < N) {
                    temp += nums[idex];
                    idex += nums[idex];
                }
                if(temp > ans) {
                    ans = temp;
                }
            }
            System.out.println(ans);
        }
    }

}
