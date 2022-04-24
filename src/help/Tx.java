package help;

public class Tx {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(text(a));
    }
    public static int text(int[] a) {
        int n = a.length;
        if (n > 1) {
            int count = countPrim(n);
            int[] remain = new int[count];
            int j = 0;
            for(int i = 2; i <= n; ++i) {
                if (isPrim(i)) {
                    remain[j++] = a[i - 1];
                }
            }
            return text(remain);
        }
        return a[0];
    }
    public static int countPrim(int n) {
        int count = 0;
        for(int i = 2; i <= n; ++i) {
            if (isPrim(i)) {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrim(int num) {
        if(num == 2) return true;
        for(int i = 2; i < num; ++i) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
