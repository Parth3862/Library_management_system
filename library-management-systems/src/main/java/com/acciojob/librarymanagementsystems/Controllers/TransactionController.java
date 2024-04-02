package com.acciojob.librarymanagementsystems.Controllers;

import com.acciojob.librarymanagementsystems.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PutMapping("issueBook")
    public String issueBook(@RequestParam("cardId")Integer cardId,
                            @RequestParam("bookId")Integer bookId) {

        try {
            String result = transactionService.issueBook(bookId,cardId);
            return result;
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
