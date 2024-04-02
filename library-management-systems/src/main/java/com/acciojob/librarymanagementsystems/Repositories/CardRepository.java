package com.acciojob.librarymanagementsystems.Repositories;


import com.acciojob.librarymanagementsystems.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<LibraryCard,Integer> {

}
