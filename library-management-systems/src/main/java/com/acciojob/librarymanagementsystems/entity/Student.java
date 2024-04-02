package com.acciojob.librarymanagementsystems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roll_id;

    @Column(nullable = false)
    private String studentName;
    private String branch;

    @Column(nullable = false)
    private double cgpa;

    @Column(unique = true)
    private String emailId;
}
