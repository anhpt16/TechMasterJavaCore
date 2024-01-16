public class Homework2 {
    public static void main(String[] args) {
        String s = "I love you";
        System.out.println(s + "forever");
        System.out.println(s.substring(0, 8));
//        String s1 = s.substring(0, 2);
//        String s2 = s.substring(2, 6);
//        String s3 = s.substring(6);
//        s2 = "hate";
//        System.out.println(s1 + s2 + s3);
        String[] str = s.split(" ");
        str[1] = "hate";
        System.out.println(str[0] + " " + str[1] + " " + str[2]);
    }
}
