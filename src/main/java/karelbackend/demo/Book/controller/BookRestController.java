package karelbackend.demo.Book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import karelbackend.demo.Book.service.BookService;
import karelbackend.demo.Book.model.Book;

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
        return bookService.getTotalValueOfCollection(); 
    }
    @GetMapping("/mostExpensive")
    public Book getMostExpensive(){
        return bookService.getMostExpensiveBook();
    }
    @GetMapping("/search/priceMoreThen")
    public List<Book> getBooksWithPriceMoreThan(@RequestParam("price")int price){
        return bookService.getBooksWithPriceMoreThan(price);
    }
    @GetMapping("/search/title/{title}")
    public Book getBookWithTitle(@PathVariable("title")String title){
        return bookService.getBookWithTitle(title);
    }
    @GetMapping("/search/inColor")
    public List<Book> getBooksInColor(){
        return bookService.getBooksInColor();
    }
    @GetMapping("/search")
    public Book getBookWithId(@RequestParam("id")int id){
        return bookService.getBookWithId(id);
    }
    @GetMapping("search/price/{price}/numberInStock/{numberInStock}")
    public List<Book> getBooksWithPriceAndNumberInStockGreaterthan(@PathVariable("price")double price,@PathVariable("numberInStock")int numberInStock){
        return bookService.getBooksWithPriceAndNumberInStockGreaterthan(price, numberInStock);
    }
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @DeleteMapping("/remove/{title}")
    public Book removeBook(@PathVariable("title")String title){
        return bookService.removeBook(title);
    }
    @DeleteMapping("/remove")
    public Book removeBook(@RequestParam("id")int id){
        return bookService.removeBook(id);
    }
}
