package com.example.jwt.Service.NaissService;
import com.example.jwt.Entity.*;
import java.util.Date;

public interface NaissService{

    void ajoutDeclaration(Acte acte,
                          Declarant declarant, 
                          Pere pere, 
                          Mere mere,
                          Declare declare,
                          Registre registre,
                          StructureSanitaire structureSani);
          

} 