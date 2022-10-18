package com.example.booklibrary.Service;

import com.example.booklibrary.Repository.BookRepository;
import com.example.booklibrary.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    BookRepository bookRepository;


    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;

    }
    public Book getBooksById(long id)
    {
        Book book= bookRepository.findByBookId(id);
       return book;
    }
    public void delete(Long id)
    {
        bookRepository.deleteById(id);
    }
    
    public Book saveBook(Book book){
        bookRepository.save(book);
        return book;
    }
    public Optional<Book> getBookByTitle(String title)
    {
        Optional<Book> book= (Optional<Book>) (bookRepository.findBookByBookTitle(title));
        return book;
    }
    public void Update(Book books)
    {
        bookRepository.save(books);
    }
}
