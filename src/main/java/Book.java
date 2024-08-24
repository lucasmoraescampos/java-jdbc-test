public class Book {
    private long id;
    private String title;
    private String genre;
    private String author;
    private String publisher;

    public Book(long id, String title, String genre, String author, String publisher) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String title, String genre, String author, String publisher) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String toString() {
        String bookStr = "Book %d\n"
            + "\tTitle: %s\n"
            + "\tGenre: %s\n"
            + "\tAuthor: %s\n"
            + "\tPublish: %s";
        return String.format(bookStr, this.id, this.title, this.genre, this.author, this.publisher);
    }
}
