package com.acciojob.librarymanagementsystems.Services;


import com.acciojob.librarymanagementsystems.Exceptions.InvalidPageCountException;
import com.acciojob.librarymanagementsystems.Repositories.AuthorRepository;
import com.acciojob.librarymanagementsystems.Repositories.BookRepository;
import com.acciojob.librarymanagementsystems.entity.Author;
import com.acciojob.librarymanagementsystems.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
     @Autowired
    private BookRepository bookRepository;

     @Autowired
    private AuthorRepository authorRepository;

     public String addBook(Book book) throws Exception{
         if(book.getNoOfPages()<=0) {
             throw new InvalidPageCountException("page count is Incorrect");
         }
         bookRepository.save(book);
         return "Book has been added in DB";
     }

     public String associateBookAndAuthor(Integer bookId,Integer authorId) throws Exception{
         Optional<Book> bookOptional = bookRepository.findById(bookId);
         if(bookOptional.isEmpty()){
             throw new Exception("Book Id is Incorrect");
         }
         Book book = bookOptional.get();

         Optional<Author> authorOptional = authorRepository.findById(authorId);
         if(authorOptional.isEmpty()){
             throw new Exception("Author Id is Incorrect");
         }
         Author author = authorOptional.get();

         book.setAuthor(author);
         author.setNoOfBooks(1+author.getNoOfBooks());

         bookRepository.save(book);
         authorRepository.save(author);
         return "Book and Author have been associated";
     }

    public List<Book> findBooksByAuthor(Integer authorId) {
        List<Book> bookList = bookRepository.findAll();
        List<Book> ansList = new ArrayList<>();
        for (Book book : bookList) {
            Integer bookAuthorId = book.getAuthor().getAuthorId();
            if (bookAuthorId.equals(authorId)) {
                ansList.add(book);
            }
        }
        return ansList;
    }

}
