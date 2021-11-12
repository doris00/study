public class HelloWorld {

    public static void add(Integer i) {
        int val = i.intValue();
        val += 3;
        i = new Integer(val);
    }

    public static void main(String[] args) {
        int a = 0, c = 0;
        do {
            --c;
            a= a-1;
        }while (a > 0);
        System.out.println(c);
    }
}
