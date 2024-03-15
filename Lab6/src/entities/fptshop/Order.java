package entities.fptshop;

import java.time.LocalDateTime;
import java.util.Map;

public class Order {
    private int id;
    private LocalDateTime orderTime;
    private String status;
    private double total;
    private Map<Integer, Integer> products;
    private Customer customer;
}
