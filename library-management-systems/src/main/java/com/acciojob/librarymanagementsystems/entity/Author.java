package com.acciojob.librarymanagementsystems.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String name;
    private int age;
    private String emailId;
    private double rating;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int noOfBooks;
}
