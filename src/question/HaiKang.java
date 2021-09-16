package question;

public class HaiKang {
    public static void main(String[] args) {
        Integer num = 0;
        try {
            num = null;
            System.out.println(num);
            return;
        } catch (Exception e) {
            System.out.println(1);
        } finally {
            System.out.println(2);
        }
    }
}
