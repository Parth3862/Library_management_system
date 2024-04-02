package com.acciojob.librarymanagementsystems.Repositories;

import com.acciojob.librarymanagementsystems.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
