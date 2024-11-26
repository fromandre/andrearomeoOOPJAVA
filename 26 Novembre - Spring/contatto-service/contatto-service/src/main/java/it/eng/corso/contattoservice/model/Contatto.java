package it.eng.corso.contattoservice.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Contatti")  //Annotation che si occupa di ricercare la tabella all'interno del database
@Getter
@Setter
public class Contatto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "num_telefono") //Riprende il nome specifico dalla colonna così che possiamo dichiarare la variabile liberamente
    private String numerotelefono;

}
