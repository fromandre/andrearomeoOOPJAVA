package it.eng.corso.contattoservice.service;


import it.eng.corso.contattoservice.model.Contatto;
import it.eng.corso.contattoservice.repository.ContattoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContattoServiceImpl implements ContattoService {
    @Autowired
    private ContattoRepository contattoRepository;

    @Override
    public Contatto save(Contatto contatto){
        return contattoRepository.save(contatto);
    }

    @Override
    public List<Contatto> findAll(){
        return contattoRepository.findAll();

    }

    @Override
    public Optional<Contatto> findById(Long id){
        return contattoRepository.findById(id);
    }

    @Override
    public List<Contatto> findByNome(String nome){
        return contattoRepository.findByNome(nome);
    }

}
