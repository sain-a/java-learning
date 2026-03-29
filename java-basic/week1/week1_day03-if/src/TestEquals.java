public class TestEquals {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        System.out.println(a == b);

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        String s3 = "abc";
        String s4 = "abc";
        System.out.println(s3 == s4);
    }
}
