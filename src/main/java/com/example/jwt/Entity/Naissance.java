package com.example.jwt.Entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Naissance extends Acte{

	@ManyToOne
    @JoinColumn(name = "registre_id")
    private Registre registre;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jugement_id")
    private Jugement jugement;
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "declarant_id")
    private Declarant declarant;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "pere_id")
    private Pere pere;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "mere_id")
    private Mere mere;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "declare_id", referencedColumnName = "id")
    private Declare declare;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "structureSani_id")
    private StructureSanitaire structureSanitaire;
}
