package it.eng.corso.taskservice.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
//@Table(name = "task")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
}
