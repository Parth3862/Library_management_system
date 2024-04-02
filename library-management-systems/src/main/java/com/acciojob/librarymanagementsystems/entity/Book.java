package com.acciojob.librarymanagementsystems.entity;

import com.acciojob.librarymanagementsystems.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    @Column (unique = true)

    private String title;
    private int noOfPages;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private int price;
    private boolean isIssued;

    @JoinColumn
    @ManyToOne
    private Author author;
}
