package com.example.jwt.Controller;
import com.example.jwt.Repository.*;
import com.example.jwt.Entity.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RegistreController {
    
    private final RegistreRepository registreRepository;

    public RegistreController(RegistreRepository registreRepository) {
        this.registreRepository = registreRepository;
    }

    @GetMapping("/registre/liste")
    public List<Registre> list(){
        return registreRepository.findAll();
    }

    @PostMapping("/registre/ajout")
    public ResponseEntity<Registre> add(@RequestBody Registre registre){
        return new ResponseEntity<Registre>(registreRepository.save(registre), HttpStatus.CREATED);
    }
}
