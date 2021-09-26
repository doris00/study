package question;
import java.util.Scanner;

public class Tencent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 0; t < T; ++t) {
            int x = sc.nextInt();//因子只差不小于x
            int a = 1 + x;
            int b = 0;
            if(isPrime(a)) {
                b = a + x;
                if(isPrime(b)) {
                    System.out.println(a * b);
                    continue;
                } else {
                    b++;
                    System.out.println(a * getNum(b));
                    continue;
                }
            } else {
                a++;
                a = getNum(a);
                b = a + x;
                if(isPrime(b)) {
                    System.out.println(a * b);
                    continue;
                } else {
                    b++;
                    System.out.println(a * getNum(b));
                    continue;
                }
            }
        }
    }
    public static int getNum (int num) {
        while (!isPrime(num)) {
            num++;
        }
        return num;
    }
    public static boolean isPrime (int num) {
        if(num <= 3) {
            return num > 1;
        }
        if(num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for(int i = 5; i <= sqrt; i += 6) {
            if(num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
