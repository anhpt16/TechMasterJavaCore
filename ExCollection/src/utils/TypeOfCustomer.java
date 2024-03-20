package utils;

public enum TypeOfCustomer {
    PERSONAL("Cá nhân"), ADMINISTRATIVE("Đơn vị hành chính"), BUSINESS("Đơn vị kinh doanh");

    public String value;

    TypeOfCustomer(String value) {
        this.value = value;
    }
}
