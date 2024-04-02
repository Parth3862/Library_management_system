package com.acciojob.librarymanagementsystems.Repositories;

import com.acciojob.librarymanagementsystems.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
