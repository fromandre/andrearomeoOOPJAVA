package it.eng.corso.bookservice.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private String uuid;
    private String title;
    private String author;
    private Double price;

    private Double stars;
}




