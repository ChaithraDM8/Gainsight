package org.bookUtil;



import java.sql.*;
import java.util.ArrayList;

public class BookStore {
    private static String url = "jdbc:mysql://localhost:3306/demo";

    public boolean addBook(Book book) {
        int count = 0;
        boolean check;
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("insert into bookstore values(?,?,?,?,?)")) {
            check = isValid(book.getCategory(), book.getBookID(), book.getPrice());
            System.out.println(check);
            if (check) {
                pst.setString(1, book.getBookID());
                pst.setString(2, book.getTitle());
                pst.setString(3, book.getAuthor());
                pst.setString(4, book.getCategory());
                pst.setDouble(5, book.getPrice());
                count = pst.executeUpdate();
            }

        } catch (InvalidBookException | SQLException e) {
            throw new RuntimeException(e);
        }
        return count == 1;
    }
    public Book findBookByTitleAndAuthor(String title, String author){
       Book book = null;
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("select * from bookstore where title = ? and author=?")) {
            pst.setString(1, title);
            pst.setString(2, author);
            ResultSet rs = pst.executeQuery();
            if (rs.next())
                book = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }
    public ArrayList<Book> displayAllBookDetails() {
        ArrayList<Book> bookList = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, "root", "chaithra");
             PreparedStatement pst = con.prepareStatement("select * from bookstore")) {
            ResultSet rs = pst.executeQuery();
            while (rs.next())
                bookList.add(new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5)));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    private boolean isValid(String category, String bookID, Double price) throws  InvalidBookException {
        if (bookID.charAt(0)!='B'|| bookID.length()!=4) throw new InvalidBookException("invalidBookException");
        else if (!(category.equalsIgnoreCase("Science") ||
                category.equalsIgnoreCase("Fiction") ||
                category.equalsIgnoreCase("Technology") ||
                category.equalsIgnoreCase("Others")))
            throw new InvalidBookException("invalidBookException");

        else if(price<0) throw new InvalidBookException("invalidBookException");

    return true;
    }

}
