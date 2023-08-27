package karelbackend.demo.Book.service;


import java.util.List;

import org.springframework.stereotype.Service;

import karelbackend.demo.Book.model.Book;
import karelbackend.demo.repo.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    


    public BookService(){
        // Book book1 = new Book("The Great Gatsby", 180, 12.99, true);
        // library.add(book1);

        // Book book2 = new Book("To Kill a Mockingbird", 320, 9.99, false);
        // library.add(book2);

        // Book book3 = new Book("1984", 280, 14.95, true);
        // library.add(book3);

        // Book book4 = new Book("Pride and Prejudice", 320, 7.50, false);
        // library.add(book4);

        // Book book5 = new Book("The Hobbit", 320, 10.50, true);
        // library.add(book5);

        // Book book6 = new Book("Harry Potter and the Sorcerer's Stone", 400, 16.99, true);
        // library.add(book6);

        // Book book7 = new Book("Fahrenheit 451", 210, 11.25, false);
        // library.add(book7);

        // Book book8 = new Book("The Catcher in the Rye", 230, 8.75, true);
        // library.add(book8);

        // Book book9 = new Book("Lord of the Rings: The Fellowship of the Ring", 450, 13.50, true);
        // library.add(book9);

        // Book book10 = new Book("The Alchemist", 210, 9.99, true);
        // library.add(book10);
    }
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    public Book addBook(Book book){
        if(bookRepository.findBookByTitle(book.getTitle())!=null){
            return null;
        }
        bookRepository.save(book);
        return book;
    }
    public double getTotalValueOfCollection(){
        double result = 0;
        for(Book book:bookRepository.findAll()){
            result+=book.getPrice()*book.getNumberInStock();
        }return result;
    }
    public Book getMostExpensiveBook() {
        List<Book> books = bookRepository.findAll();
        Book mostExpensive = null;
        if (books.size()>0) {
            mostExpensive = books.get(0);
            for(Book book : books) {
                if (book.getPrice() > mostExpensive.getPrice())
                    mostExpensive = book;
            }
        }
        return mostExpensive;
    }
    public List<Book> getBooksWithPriceMoreThan(int price){
        return bookRepository.findBooksByPriceGreaterThan(price);
    }
    public Book getBookWithTitle(String title){
        return bookRepository.findBookByTitle(title);
    }
    public List<Book> getBooksInColor(){
        return bookRepository.findBooksByinColorIsTrue();
    }
    public Book getBookWithId(int id){
        return bookRepository.findBookById(id);
    }
    public Book removeBook(String title){
        Book book = bookRepository.findBookByTitle(title);
        bookRepository.delete(book);
        return book;
    }
    public Book removeBook(int id){
        Book book = bookRepository.findBookById(id);
        bookRepository.delete(book);
        return book;
    }
    public List<Book> getBooksWithPriceAndNumberInStockGreaterthan(double price, int numberInStock){
        return bookRepository.findBooksByPriceGreaterThanAndNumberInStockGreaterThan(price, numberInStock);
    }
}
