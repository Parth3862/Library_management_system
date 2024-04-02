package com.acciojob.librarymanagementsystems.Controllers;


import com.acciojob.librarymanagementsystems.Services.AuthorService;
import com.acciojob.librarymanagementsystems.entity.Author;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("addAuthor")
    public String addAuthor(@RequestBody Author author){
        String res = authorService.addAuthor(author);
        return res;
    }

    @GetMapping("getAuthorWithMaxBooks")
    public Author getAuthorWithMaxBooks(){
       Author author= authorService.getAuthorWithMaxBooks();
       return author;
    }
}
