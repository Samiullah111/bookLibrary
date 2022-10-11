package com.example.booklibrary.Controller;

import com.example.booklibrary.Service.BooksService;
import com.example.booklibrary.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class BooksController {

    @Autowired
    BooksService booksService;

    @RequestMapping("/")
    public String homePage(){
        return "book";
    }

    @GetMapping ("/AllBooks")
    public String getBooks(Model model){
        List<Book> books = booksService.getAllBooks();
        if(books.isEmpty()){
            model.addAttribute("msg", "no books found!");
            return "AllBooks";
        }else{
            model.addAttribute("books", books);
            return "AllBooks";
        }

    }
    @PostMapping("/newBook")
    public ResponseEntity<?> saveBook(@Valid Book book){
        Book book1= booksService.saveBook(book);
        if(book1.getBookId()!=null){
            return ResponseEntity.ok("Success");
        }else {
            return ResponseEntity.ok("Error");
        }
    }
    @GetMapping ("/books/{bookId}")
    private ResponseEntity<Optional<Book>> getBooks(@PathVariable("bookId") Long bookId){
            Optional<Book> book  = booksService.getBooksById(bookId);
            return ResponseEntity.ok(book);
    }
    @DeleteMapping("/books/{bookId}")
    private ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId){
        Optional<Book> bk =  booksService.getBooksById(bookId);
        if(bk.isEmpty())
        return ResponseEntity.ok("Item with id: " + bookId + " not exist.");
        else  {
            booksService.delete(bookId);
            return ResponseEntity.ok("Item Deleted");
        }
    }
    @GetMapping ("/booksByTitle/{bookTitle}")
    private ResponseEntity<?> getBookByTitle(@PathVariable("bookTitle") String bookTitle) {
        Optional<Book> Bks = booksService.getBookByTitle(bookTitle);
        if (Bks.isEmpty()) {
            return ResponseEntity.ok("Book Title " + bookTitle + " Not Found ");
        } else {
            return ResponseEntity.ok(Bks);

        }
    }
    @PutMapping("/books/{bookId}")

    private ResponseEntity<?> update(@RequestBody Book books,@PathVariable("bookId") Long bookId)
    {
        Optional<Book> bk =  booksService.getBooksById(bookId);
        if(bk.isEmpty()){
            return ResponseEntity.ok("Book Title " + bookId + " Not Found ");
        }
        else{
            booksService.Update(books);
            return ResponseEntity.ok(books);
        }
    }

}
