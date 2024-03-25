package utils;

public enum TypeCustomer {
    PERSONAL("Cá nhân"), ADMINISTRATIVE("Đơn vị hành chính"), BUSINESS("Đơn vị kinh doanh");

    public String value;
    TypeCustomer(String value){
        this.value = value;
    }
}
