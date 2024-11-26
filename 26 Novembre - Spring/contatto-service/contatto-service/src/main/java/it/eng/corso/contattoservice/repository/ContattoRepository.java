package it.eng.corso.contattoservice.repository;
import it.eng.corso.contattoservice.model.Contatto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContattoRepository extends JpaRepository<Contatto, Long>{
    public List<Contatto> findByNome(String nome);
}
