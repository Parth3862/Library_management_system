package com.acciojob.librarymanagementsystems.Services;

import com.acciojob.librarymanagementsystems.entity.Student;
import com.acciojob.librarymanagementsystems.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student) {

        studentRepository.save(student);
        return "Student has been Saved to the DB";
    }

}