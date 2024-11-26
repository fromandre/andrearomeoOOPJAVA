package it.eng.corso.contattoservice.controller;
import it.eng.corso.contattoservice.model.Contatto;
import it.eng.corso.contattoservice.service.ContattoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContattoController {

        @Autowired
        private ContattoService contattoService;

        @GetMapping("/api/v1/contatti")
        public List<Contatto> findAll(){
            return contattoService.findAll();
        }

        @GetMapping("/api/v1/{id}")
        public Optional<Contatto> findById(@PathVariable Long id){
                return contattoService.findById(id);
        }

        @GetMapping("/api/v1/search")
        public List<Contatto> findByNome(@RequestParam String nome){
                return contattoService.findByNome(nome);
        }

        @PostMapping("/api/v1/contatti")
        public Contatto save(@RequestBody Contatto c){
                return contattoService.save(c);
        }
        
}
