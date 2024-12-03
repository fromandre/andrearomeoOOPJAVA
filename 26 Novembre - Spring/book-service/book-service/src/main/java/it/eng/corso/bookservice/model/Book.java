package it.eng.corso.bookservice.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private double price;


}