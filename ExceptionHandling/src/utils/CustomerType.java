package utils;

public enum CustomerType {
    INDIVIDUAL("Cá nhân"), GROUP("Tập thể"), BUSINESS("Doanh nghiệp");

    public String value;

    CustomerType(String value) {
        this.value = value;
    }
}
