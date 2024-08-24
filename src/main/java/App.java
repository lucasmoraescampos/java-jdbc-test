import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        try {
            do {
                option = getMenuOption();
                switch (option) {
                    case "0":
                        break;
                    case "1":
                        readBooks();
                        break;
                    case "2":
                        createBook();
                        break;
                    case "3":
                        updateBook();
                        break;
                    case "4":
                        deleteBook();
                        break;
                    default:
                        System.out.println("Invalid option!");
                        break;
                }
            } while (!option.equals("0"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static String getMenuOption() {
        String menu, option;

        menu = "--- Menu: ---\n"
            + "1: List books\n"
            + "2: Create book\n"
            + "3: Update book\n"
            + "4: Delete book\n"
            + "0: Exit\n"
            + "Enter an option: ";

        System.out.print(menu);
        option = scanner.next();
        return option;
    }

    private static void createBook() throws SQLException {
        String title, genre, author, publisher;
        Book book;

        System.out.print("Enter a title: ");
        title = scanner.next();

        System.out.print("Enter a genre: ");
        genre = scanner.next();

        System.out.print("Enter an author: ");
        author = scanner.next();

        System.out.print("Enter a publisher: ");
        publisher = scanner.next();

        book = new Book(title, genre, author, publisher);

        BookDAO.create(book);

        System.out.println("Livro criado com sucesso!");
    }

    private static void readBooks() throws SQLException {
        ArrayList<Book> books = BookDAO.list();
        if (books.size() > 0) {
            books.forEach(book -> System.out.println(book));
        } else {
            System.out.println("Book list empty!");
        }
    }

    private static void updateBook() throws SQLException {
        long id;
        Book book;
        String title, genre, author, publisher;

        System.out.print("Enter an id: ");
        id = scanner.nextLong();

        book = BookDAO.find(id);
        if (book != null) {
            System.out.print("Enter a title: ");
            title = scanner.next();

            System.out.print("Enter a genre: ");
            genre = scanner.next();

            System.out.print("Enter an author: ");
            author = scanner.next();

            System.out.print("Enter a publisher: ");
            publisher = scanner.next();

            book.setTitle(title);
            book.setGenre(genre);
            book.setAuthor(author);
            book.setPublisher(publisher);

            BookDAO.update(book);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Id not found!");
        }
    }

    private static void deleteBook() throws SQLException {
        long id;
        Book book;

        System.out.print("Enter an id: ");
        id = scanner.nextLong();

        book = BookDAO.find(id);
        if (book != null) {
            BookDAO.delete(book);
            System.out.println("Livro deletado com sucesso!");
        } else {
            System.out.println("Id not found!");
        }
    }
}
