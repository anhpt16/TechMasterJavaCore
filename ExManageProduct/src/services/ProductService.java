package services;

import entities.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import Utils.Constant;

public class ProductService {
    public String addProduct(Scanner sc, ArrayList<Product> products){
        System.out.print("Nhập số lượng sản phẩm: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập thông tin cho sản phẩm " + (i + 1));
            //Process id for product
            boolean checkId = true;
            int id;
            do {
                System.out.print("--Nhập id: ");
                id = Integer.parseInt(sc.nextLine());
                for (Product p : products){
                    if (p.getId() == id){
                        System.out.println("Đã tồn tại id");
                        checkId = false;
                        break;
                    }
                }
            } while (checkId == false);

            System.out.print("--Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("--Nhập mô tả: ");
            String description = sc.nextLine();
            System.out.print("--Nhập số lượng: ");
            int quantity = Integer.parseInt(sc.nextLine());
            //Process price for product
            BigDecimal price = null;
            boolean checkPriceEx = false;
            do {
                System.out.print("--Nhập giá tiền: ");
                String priceString = sc.nextLine();
                if(priceString.matches("-?\\d+(\\.\\d+)?") == true){
                    price = new BigDecimal(priceString);
                    checkPriceEx = true;
                }
                else{
                    System.out.println("Giá nhập vào không hợp lệ !");
                    System.out.println("VD: 12345.234");
                }
            } while(checkPriceEx == false);

            System.out.print("--Nhập đơn vị tính: ");
            String unit = sc.nextLine();
            products.add(new Product(id, name, description, quantity, price, unit));
        }
        return "Thêm thành công !";
    }

    public void displayListProduct(ArrayList<Product> products){
        for (Product p : products){
            System.out.println(p);
        }
    }

    public void searchProductByName(Scanner sc, ArrayList<Product> products){
        System.out.print("Nhập tên sản phẩm muốn tìm: ");
        String nameSearch = sc.nextLine();
        int count = 0;
        for (Product p : products){
            if (p.getName().toLowerCase().contains(nameSearch.toLowerCase())){
                System.out.println(p);
                count++;
            }
        }
        if(count == 0)
            System.out.println("Không tìm thấy sản phẩm nào !");
    }

    public void searchProductById(Scanner sc, ArrayList<Product> products){
        System.out.print("Nhập id sản phẩm: ");
        int idSearch = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (Product p : products){
            if(p.getId() == idSearch){
                System.out.println(p);
                count++;
                int choose = 0;
                do {
                    System.out.println("-------------------------");
                    System.out.println("31. Xóa sản phẩm");
                    System.out.println("32. Cập nhật số lượng");
                    System.out.println("10. Quay lại");
                    System.out.print("--> Chọn: ");
                    choose = Integer.parseInt(sc.nextLine());
                    System.out.println("-------------------------");

                    switch (choose){
                        case Constant.DELETE_PRODUCT:
                            products.remove(p);
                            System.out.println("Xóa thành công !");
                            choose =10;
                            break;
                        case Constant.UPDATE_PRODUCT:
                            System.out.println("Nhập số lượng mới: ");
                            int quantity = Integer.parseInt(sc.nextLine());
                            p.setQuantity(quantity);
                            System.out.println("Cập nhật thành công !");
                            choose = 10;
                            break;
                        case Constant.BACK:
                            break;
                        default:
                            break;
                    }
                } while(choose != 10);
            }
        }
        if (count == 0)
            System.out.println("Không tìm thấy sản phẩm nào !");
    }

    public void searchProductLowerFive(ArrayList<Product> products){
        int count = 0;
        for (Product p : products){
            if(p.getQuantity() < 5){
                System.out.println(p);
            }
        }
        if (count == 0)
            System.out.println("Không tìm thấy sản phẩm nào !");
    }

    public void searchProductByPrice(Scanner sc, ArrayList<Product> products){
        int choose = 0;
        do {
            System.out.println("--------------------------------");
            System.out.println("51. Dưới 50.000");
            System.out.println("52. Từ 50.000 đến dưới 100.000");
            System.out.println("53. Từ 100.000");
            System.out.println("10. Quay lại");
            System.out.print("Chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("---------------------------------");

            switch (choose){
                case Constant.LOWER_50000:
                    for (Product p : products){
                        if (p.getPrice().compareTo(new BigDecimal("50000")) < 0)
                            System.out.println(p);
                    }
                    break;
                case Constant.FROM_50000_LOWER_100000:
                    for (Product p : products){
                        if ((p.getPrice().compareTo(new BigDecimal("50000")) >= 0) && (p.getPrice().compareTo(new BigDecimal("100000")) < 0))
                            System.out.println(p);
                    }
                    break;
                case Constant.FROM_100000:
                    for (Product p : products){
                        if (p.getPrice().compareTo(new BigDecimal("100000")) >= 0)
                            System.out.println(p);
                    }
                    break;
                case Constant.BACK:
                    break;
                default:
                    break;
            }
        } while(choose != 10);
    }

    public void Menu(Scanner sc, ArrayList<Product> products){
        int choose = 0;
        do {
            System.out.println("---------------------------------");
            System.out.println("6- Thêm sản phẩm");
            System.out.println("1- Xem danh sách sản phẩm");
            System.out.println("2- Tìm sản phẩm theo tên");
            System.out.println("3- Tìm sản phẩm theo id");
            System.out.println("4- Tìm các sản phẩm có số lượng dưới 5");
            System.out.println("5- Tìm sản phẩm theo mức giá");
            System.out.println("0- Thoát");
            System.out.print("-->Nhập lựa chọn: ");
            choose = Integer.parseInt(sc.nextLine());
            System.out.println("-----------------------------------");

            switch (choose){
                case Constant.DISPLAY_LIST_PRODUCT:
                    int count = 0;
                    for (Product p : products){
                        System.out.println(p);
                        count++;
                    }
                    if (count == 0)
                        System.out.println("Chưa có sản phẩm nào !");
                    break;
                case Constant.SEARCH_PRODUCT_BY_NAME:
                    searchProductByName(sc, products);
                    break;
                case Constant.SEARCH_PRODUCT_BY_ID:
                    searchProductById(sc, products);
                    break;
                case Constant.SEARCH_PRODUCT_LOWER_FIVE:
                    searchProductLowerFive(products);
                    break;
                case Constant.SEARCH_PRODUCT_BY_PRICE:
                    searchProductByPrice(sc, products);
                    break;
                case Constant.ADD_PRODUCT:
                    System.out.println(addProduct(sc, products));
                    break;
                case Constant.EXIT:
                    break;
                default:
                    break;
            }
        } while(choose != 0);

    }
}
