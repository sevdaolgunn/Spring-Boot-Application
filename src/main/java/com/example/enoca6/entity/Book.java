package com.example.enoca6.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "yearofPublication")
    private Long yearOfPublication;
    @Column(name = "isbn")
    private Long isbn;
    @Column(name = "author_id")
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "author_id", insertable = false, updatable = false ,nullable = false, foreignKey = @ForeignKey(name = "FK__book__author"))
    private Author author;
}
