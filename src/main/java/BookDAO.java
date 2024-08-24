import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDAO {
    public static Book find(long id) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM books WHERE id = ? LIMIT 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String title = resultSet.getString("title");
            String genre = resultSet.getString("genre");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            return new Book(id, title, genre, author, publisher);
        }
        return null;
    }

    public static void create(Book book) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO books (title, genre, author, publisher) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getGenre());
        statement.setString(3, book.getAuthor());
        statement.setString(4, book.getPublisher());
        statement.executeUpdate();
    }

    public static ArrayList<Book> list() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "SELECT * FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Book> list = new ArrayList<Book>();
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String title = resultSet.getString("title");
            String genre = resultSet.getString("genre");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            Book book = new Book(id, title, genre, author, publisher);
            list.add(book);
        }
        return list;
    }

    public static void update(Book book) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "UPDATE books SET title = ?, genre = ?, author = ?, publisher = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getGenre());
        statement.setString(3, book.getAuthor());
        statement.setString(4, book.getPublisher());
        statement.setLong(5, book.getId());
        statement.executeUpdate();
    }

    public static void delete(Book book) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, book.getId());
        statement.executeUpdate();
    }
}
