package dao;

import dto.Book;
import util.DataBaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, publisher, publication_year, isbn) " +
                "VALUES (?, ?, ?, ?, ?) ";
        try(Connection conn = DataBaseUtil.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getPublicationYear());
            pstmt.setString(5, book.getIsbn());
            pstmt.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM books ";
        try(Connection conn = DataBaseUtil.getConnection();
            Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publicationYear = rs.getInt("publication_year");
                String isbn = rs.getString("isbn");
                boolean available = rs.getBoolean("available");

                Book book = new Book(id, title, author, publisher, publicationYear, isbn, available);
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> searchBooksTitle(String searchTitle) throws SQLException {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT * FROM books where title like ?";
        try (Connection conn = DataBaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + title + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                int publicationYear = rs.getInt("publication_year");
                String isbn = rs.getString("isbn");
                boolean available = rs.getBoolean("available");

                Book book = new Book(id, title, author, publisher, publicationYear, isbn, available);
                bookList.add(book);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        BookDAO bookDAO = new BookDAO();
        try {
           // bookDAO.getAllBooks();

            ArrayList selectedBookedList = (ArrayList) bookDAO.searchBooksTitle("알고");
            for (int i = 0; i < selectedBookedList.size(); i++) {
                System.out.println(bookDAO.getAllBooks().get(i));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
