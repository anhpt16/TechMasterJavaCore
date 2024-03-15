package entities;

public class News {
    private String title;
    private String author;
    private String publicDate;
    private double rate;

    public News(String title, String author, String publicDate, double rate) {
        this.title = title;
        this.author = author;
        this.publicDate = publicDate;
        this.rate = rate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public double getRate() {
        return rate;
    }
}
