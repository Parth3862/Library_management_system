package com.acciojob.librarymanagementsystems.Services;


import com.acciojob.librarymanagementsystems.Repositories.BookRepository;
import com.acciojob.librarymanagementsystems.Repositories.CardRepository;
import com.acciojob.librarymanagementsystems.Repositories.TransactionRepository;
import com.acciojob.librarymanagementsystems.entity.Book;
import com.acciojob.librarymanagementsystems.entity.LibraryCard;
import com.acciojob.librarymanagementsystems.entity.Transaction;
import com.acciojob.librarymanagementsystems.enums.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
     private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public static int MAX_NO_OF_ISSUED_BOOKS=3;
    public String issueBook(Integer bookId,Integer cardId) throws Exception{
        // 1. we need to find book and card from repositories
        //2. create the transaction object
        //3. set the revelant attributes for transaction objects
        //4.change the attributes of card and book entity

        // book should be valid
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new Exception("BookId is incorrect");
        }
        Book book = bookOptional.get();

        // now library card also should be valid
        Optional<LibraryCard> libraryCardOptional = cardRepository.findById(cardId);
        if(libraryCardOptional.isEmpty()){
            throw new Exception("CardId is incorrect");
        }
        LibraryCard card = libraryCardOptional.get();
        Transaction transaction = new Transaction();
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        // book must not be issued
        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "Book is already Issued";
        }

        // card limit exceeded
        if(card.getNoOfBooksIssued()>MAX_NO_OF_ISSUED_BOOKS){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "Max Limit Reached";
        }
        // checking if card has expired validity
        LocalDate currDate = LocalDate.now();
        if(currDate.isAfter(card.getValidity())){
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transactionRepository.save(transaction);
            return "Card Expired";
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        card.setNoOfBooksIssued(card.getNoOfBooksIssued()+1);

        cardRepository.save(card);
        bookRepository.save(book);
        transaction = transactionRepository.save(transaction);
        return "The transaction has been completed with transactionId "+transaction.getTransactionId();
    }
}
