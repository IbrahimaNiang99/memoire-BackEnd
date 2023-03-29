package com.example.jwt.Entity;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Declarant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String prenom;
    private String nom;
    private String cni;
    private String adresse;
    private String degresParental;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCni() {
        return cni;
    }
    public void setCni(String cni) {
        this.cni = cni;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getDegresParental() {
        return degresParental;
    }
    public void setDegresParental(String degresParental) {
        this.degresParental = degresParental;
    }

    @OneToMany(mappedBy = "declarant", cascade=CascadeType.ALL)
    private Set<Naissance> naissance;
    
}