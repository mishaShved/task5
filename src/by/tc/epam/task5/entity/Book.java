package by.tc.epam.task5.entity;


import java.util.Objects;

public class Book {
        
    private String author;
    private String title;
    private String genre;
    private double price;
    private String date;
    private String description;

    public Book() {
    }

    public Book(String author, String title, String genre, double price, String date, String description) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.date = date;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }    

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(date, book.date) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, title, genre, price, date, description);
    } 

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }    
    
}
