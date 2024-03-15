import entities.News;
import services.NewsService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NewsService newsService = new NewsService();
        System.out.print("Nhập tiêu đề: ");
        String title = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        String author = sc.nextLine();
        System.out.print("Nhập ngày: ");
        String publicDate = sc.nextLine();
        System.out.print("Nhập đánh giá: ");
        double rate = Double.parseDouble(sc.nextLine());

        newsService.display(new News(title, author, publicDate, rate));
    }
}
