package karelbackend.demo.repo;
import karelbackend.demo.Book.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long> {
 public List<Book> findUsersByAgeAfter(int age);
 public Book findUserByEmail(String email);
 public Book findBookByTitle(String title);
 
}
