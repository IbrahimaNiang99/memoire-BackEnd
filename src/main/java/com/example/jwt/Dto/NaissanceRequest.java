package com.example.jwt.Dto;
import com.example.jwt.Entity.*;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class NaissanceRequest {
    private Acte acte;
    private Declarant declarant;
    private Mere mere;
    private Pere pere;
    private Declare declare;
    private Jugement jugement;
    private Registre registre;
    private StructureSanitaire structureSanitaire;
    
}
