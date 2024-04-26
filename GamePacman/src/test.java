public class test {
    public static void main(String[] args) {
        for (int i = 72; i >= 48; i--) {
            int remainder = i % 24;
            System.out.println(i + " chia lấy dư cho 24 bằng " + remainder);
        }
    }
}
