package com.acciojob.librarymanagementsystems.Controllers;

import com.acciojob.librarymanagementsystems.Repositories.CardRepository;
import com.acciojob.librarymanagementsystems.Repositories.StudentRepository;
import com.acciojob.librarymanagementsystems.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("card")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/generatecard")
    public ResponseEntity addcard(){
        String res= cardService.generateCard();
        return new ResponseEntity(res, HttpStatus.OK);
    }

    @PutMapping("/associateCardAndStudent")
    public ResponseEntity associatedCardAndStudent(@RequestParam("cardId") Integer cardId,
                                                   @RequestParam("studentId") Integer studentId){
        String res = cardService.associateCardAndStudent(cardId,studentId);
        return new ResponseEntity(res,HttpStatus.OK);
    }
}
