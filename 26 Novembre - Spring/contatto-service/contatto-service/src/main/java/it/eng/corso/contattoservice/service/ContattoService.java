package it.eng.corso.contattoservice.service;

import it.eng.corso.contattoservice.model.Contatto;

import java.util.List;
import java.util.Optional;

public interface ContattoService {
    Contatto save(Contatto contatto);
    List<Contatto> findAll();
    Optional<Contatto> findById(Long id);
    List<Contatto> findByNome(String nome);
    void delete(Long id);
}
