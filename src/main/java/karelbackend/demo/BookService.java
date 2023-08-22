package karelbackend.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class BookService {

    public List<Book> library = new ArrayList<>();


    public BookService(){
        Book book1 = new Book("The Great Gatsby", 180, 12.99, true);
        library.add(book1);

        Book book2 = new Book("To Kill a Mockingbird", 320, 9.99, false);
        library.add(book2);

        Book book3 = new Book("1984", 280, 14.95, true);
        library.add(book3);

        Book book4 = new Book("Pride and Prejudice", 320, 7.50, false);
        library.add(book4);

        Book book5 = new Book("The Hobbit", 320, 10.50, true);
        library.add(book5);

        Book book6 = new Book("Harry Potter and the Sorcerer's Stone", 400, 16.99, true);
        library.add(book6);

        Book book7 = new Book("Fahrenheit 451", 210, 11.25, false);
        library.add(book7);

        Book book8 = new Book("The Catcher in the Rye", 230, 8.75, true);
        library.add(book8);

        Book book9 = new Book("Lord of the Rings: The Fellowship of the Ring", 450, 13.50, true);
        library.add(book9);

        Book book10 = new Book("The Alchemist", 210, 9.99, true);
        library.add(book10);
    }
    public List<Book> getAllBooks(){
        return library;
    }
    public void addBook(Book book){
        library.add(book);
    }
    public double getTotalValue(){
        double sum = 0;
        for(Book book:library){
            sum += book.getnumberInStock()*book.getPrice();
        }return sum;
    }
    public Book getMostExpensive(){
        Book result = library.get(0);
        for(Book book:library){
            if(book.getPrice()> result.getPrice()){
                result = book;
            }
        }return result;
    }
    public List<Book> getBooksWithPriceAbove(int price){
        List<Book> array = new ArrayList<>();
        for(Book book: library){
            if(book.getPrice()>price){
                array.add(book);
            }
        }return array;
    }
    public List<Book> getBooksWithTitle(String title){
        List<Book> array = new ArrayList<>();
        for(Book book: library){
            if(book.getTitle().toLowerCase().equals(title.toLowerCase())){
                array.add(book);
            }
        }return array;
    }
    public List<Book> getBooksInColor(){
        List<Book> array = new ArrayList<>();
        for(Book book: library){
            if(book.getinColor()){
                array.add(book);
            }
        }return array;
    }
}
