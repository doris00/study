package question;

import java.util.Arrays;
import java.util.Scanner;

public class Lazada {
    public static  boolean isPrime(int x) {
        if(x == 1) {
            return false;
        }
        for(int i = 2; i * i <= x; ++i) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int countPrims(int n) {
        int[] isPrime = new int[n + 1];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for(int i = 2; i <= n; ++i) {
            if(isPrime[i] == 1) {
                ans += 1;
                if((long) i * i <= n) {
                    for(int j = i * i; j <= n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
    public static int countPrims(int l, int r) {
        int[] isPrime = new int[r + 1];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        if(l < 2) {
            l = 2;
        }
        for(int i = l; i <= r; ++i) {
            if(isPrime[i] == 1) {
                ans += 1;
                if((long) i * i <= r) {
                    for(int j = i * i; j <= r; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
    public static String compress(String s) {
        if(s.length() == 0) {
            return s;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = s.charAt(0);
        for(int i = 1; i < s.length(); ++i) {
            if(ch == s.charAt(i)) {
                cnt++;
            } else {
                if(cnt > 1) {
                    ans.append(cnt);
                }
                ans.append(ch);
                ch = s.charAt(i);
                cnt = 1;
            }
        }
        if(cnt > 1) {
            ans.append(cnt);
        }
        ans.append(ch);
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            String s = in.next();
//            System.out.println(compress(s));
//        }
        int m = in.nextInt();
        int l, r;
        for(int i = 0; i < m; ++i) {
            l = in.nextInt();
            r = in.nextInt();
            int n1 = countPrims(l);
            int n2 = countPrims(r);
            int ans = n2 - n1;
            if(ans == 0) {
                ans += 1;
            } else if(isPrime(l)) {
                ans += 2;
            }
            System.out.println(ans);
        }
    }
}
