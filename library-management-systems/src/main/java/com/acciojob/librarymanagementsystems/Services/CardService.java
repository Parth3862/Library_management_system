package com.acciojob.librarymanagementsystems.Services;

import com.acciojob.librarymanagementsystems.Repositories.CardRepository;
import com.acciojob.librarymanagementsystems.Repositories.StudentRepository;
import com.acciojob.librarymanagementsystems.entity.LibraryCard;
import com.acciojob.librarymanagementsystems.entity.Student;
import com.acciojob.librarymanagementsystems.enums.CardStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private StudentRepository studentRepository;

    public String generateCard(){
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardStatus(CardStatus.NEW);
        libraryCard.setNoOfBooksIssued(0);


        LocalDate expiryDate = LocalDate.of(2024, 5, 6);
        //Date expiryDate = new Date();
        libraryCard.setValidity(expiryDate);
        libraryCard=cardRepository.save(libraryCard);
        return "The card has been generated with cardId"+libraryCard.getCardNo();
    }

    public String associateCardAndStudent(Integer cardId,Integer studentId){
        LibraryCard libraryCard=cardRepository.findById(cardId).get();
        Student student = studentRepository.findById(studentId).get();
        libraryCard.setCardStatus(CardStatus.ISSUED);
        libraryCard.setStudent(student);

        cardRepository.save(libraryCard);
        return "The card and student has been associated";
    }
}
