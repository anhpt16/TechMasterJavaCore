import entities.Product;
import services.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        //Data
        Product p1 = new Product(1, "Sữa ông thọ", "Sữa", 10, new BigDecimal("65500"), "VND");
        Product p2 = new Product(2, "Bánh chocopie", "Bánh", 20, new BigDecimal("105000"), "VND");
        Product p3 = new Product(3, "Bánh chuối", "Bánh", 200, new BigDecimal("15000"), "VND");
        Product p4 = new Product(4, "Kẹo lạc", "Kẹo", 4, new BigDecimal("12000"), "VND");
        Product p5 = new Product(5, "Bim bim khoai tây", "Bim bim", 3, new BigDecimal("12000"), "VND");
        ArrayList<Product> products = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5));

        productService.Menu(sc, products);
    }
}
