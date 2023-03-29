package com.example.jwt.Service.NaissService;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jwt.Entity.Acte;
import com.example.jwt.Entity.Declarant;
import com.example.jwt.Entity.Declare;
import com.example.jwt.Entity.Mere;
import com.example.jwt.Entity.Pere;
import com.example.jwt.Entity.Personne;
import com.example.jwt.Entity.Registre;
import com.example.jwt.Entity.StructureSanitaire;
import com.example.jwt.Repository.RegistreRepository;

@Service
@Transactional
public class NaissServiceImpl implements NaissService{
    
    @Autowired
    private RegistreRepository registreRepository;

    @Override
    public void ajoutDeclaration(Acte acte, Declarant declarant,
            Pere pere, Mere mere, Declare declare, Registre registre, StructureSanitaire structureSani) {
        // TODO Auto-generated method stub
        
    }




    
}
