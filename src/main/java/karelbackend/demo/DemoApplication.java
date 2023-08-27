package karelbackend.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import karelbackend.demo.Book.model.Book;
import karelbackend.demo.Book.repo.BookRepository;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Book book1 = new Book("title",15,20,true);
		// BookService service = new BookService();
		// service.addBook(book1);
		
		
		SpringApplication.run(DemoApplication.class, args);
	}

}
