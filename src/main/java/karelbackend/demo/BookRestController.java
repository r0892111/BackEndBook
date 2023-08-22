package karelbackend.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/book")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/totalValue")
    public double getTotalValue(){
        return bookService.getTotalValue(); 
    }
    @GetMapping("/mostExpensive")
    public Book getMostExpensive(){
        return bookService.getMostExpensive();
    }
    @GetMapping("/search/priceMoreThen")
    public List<Book> getBooksWithPriceMoreThan(@RequestParam("price")int price){
        return bookService.getBooksWithPriceAbove(price);
    }
    @GetMapping("search/title/{title}")
    public List<Book> getBookWithTitle(@PathVariable("title")String title){
        return bookService.getBooksWithTitle(title);
    }
    @GetMapping("search/inColor")
    public List<Book> getBooksInColor(){
        return bookService.getBooksInColor();
    }
}
