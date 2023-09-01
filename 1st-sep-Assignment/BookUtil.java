package org.bookUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class BookUtil {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BookStore bookStore = new BookStore();
        Book book = null;
      //Reading input from user
        for(int i=0;i<3;i++) {
            System.out.println("Enter bookId, Title, author, category,price");
            String bookId = sc.next();
            String title = sc.next();
            String author = sc.next();
            String category = sc.next();
            Double price = sc.nextDouble();
            book = new Book(bookId, title, author, category, price);
            //adding the book
            if (bookStore.addBook(book)) {
                System.out.println("Book added Succesfully");
            }
        }

//Search the books by title and author
        String title = sc.next();
           String author = sc.next();
       book= bookStore.findBookByTitleAndAuthor(title,author);
       if(book!=null)
        System.out.println(book.toString());
       else
           System.out.println("Book not Found");

        //Display all the book details
        ArrayList<Book> books= bookStore.displayAllBookDetails();
        for(int i=0;i<books.size();i++)
            System.out.println(books.get(i).toString());
    }
}
