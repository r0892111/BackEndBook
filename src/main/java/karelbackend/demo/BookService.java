package karelbackend.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class BookService {

    public List<Book> library = new ArrayList<>();


    public BookService(){
        Book book1 = new Book("title",15,20,true);
		library.add(book1);
    }
    public List<Book> getAllBooks(){
        return library;
    }
    public void addBook(Book book){
        library.add(book);
    }
}
