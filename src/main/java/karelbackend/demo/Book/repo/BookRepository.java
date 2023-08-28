package karelbackend.demo.Book.repo;
import karelbackend.demo.Book.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long> {
//  public List<Book> findUsersByAgeAfter(int age);
//  public Book findBookByEmail(String email);
 public Book findBookByTitle(String title);
 public List<Book> findAllByOrderByPriceDesc();
 public List<Book> findAll();
 public Book findBookById(int id);
 public List<Book> findBooksByPriceGreaterThan(int price);
 public List<Book> findBooksByinColorIsTrue();
 public List<Book> findBooksByPriceGreaterThanAndNumberInStockGreaterThan(double price, int numberInStock);
}
