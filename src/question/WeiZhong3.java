package question;

import java.text.SimpleDateFormat;
import java.util.*;

public class WeiZhong3 {
    /**
     * 闰年计算
     */
//    public static List<Integer> leapYear(int start, int end) {
//        List<Integer> leapYears = new ArrayList<>();
//        for(int i = start; i <= end; ++i) {
//            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
//                leapYears.add(i);
//            }
//        }
//        return leapYears;
//    }

    public static int[] getCY(int year) {
        int[] CY = new int[2];
        int[] digit = new int[4];
        int i = 0;
        while (year != 0) {
            digit[i++] = year % 10;
            year /= 10;
        }
        CY[0] = digit[3] * 10 + digit[2];//世纪
        CY[1] = digit[1] * 10 + digit[0];//年
        return CY;
    }
    /**
     * 使用Zeller公式
     * w = y + [y / 4] + [c / 4] - 2 * c + [26 * (m + 1) / 10] + d -1;
     * w: 星期
     * c: 世纪 - 1
     * y: 年（后两位数）
     * m: 月（3<= m <= 14） 在公式中，某年的1，2月要看做上一年的13，14月来计算
     * d: 日 []代表取整
     * w 对 7 取余，余数代表星期几
     * @param args
     */
    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner sc = new Scanner(System.in);
        int start, end;
        start = sc.nextInt();
        end = sc.nextInt();
        int count = 0;
        Calendar calendar = Calendar.getInstance();
        for (int i = start; i <= end; ++i) {
            for (int j = 1; j <= 12; ++j) {
                String str = i + "-" + j + "-01";
                Date date = sdf.parse(str);
                calendar.setTime(date);

                int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                if (week == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);

//        for (int i = start; i <= end; ++i) {
//            int y = i;
////            int[] CY = getCY(i);
////            int y = CY[1];
////            int c = CY[0];
//            for(int j = 1; j <= 12; ++j) {
//                int m = j;
//                if(m == 1) {
//                    m = 13;
//                    y--;
//                }
//                if(m == 2) {
//                    m = 14;
//                    y--;
//                }
////                int w = y + y / 4 + c / 4 - 2 * c + 26 * (m + 1) / 10;
//                int w = 1 + 2 * m + (3 * (m + 1) / 5) + y + y / 4 - y / 100 + y / 400;
//                if (w % 7 == 0) {
//                    count++;
//                }
//            }
//        }
//        System.out.println(count);
    }
}
