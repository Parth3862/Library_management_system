package com.acciojob.librarymanagementsystems.Repositories;

import com.acciojob.librarymanagementsystems.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {

}
