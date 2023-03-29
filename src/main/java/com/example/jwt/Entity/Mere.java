package com.example.jwt.Entity;

import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;


@Entity
public class Mere extends Personne{
    
    // @OneToMany(mappedBy="mere")
    // private Set<Naissance> mere;
}
