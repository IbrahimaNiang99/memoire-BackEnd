package com.example.jwt.Entity;

import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Pere extends Personne{
    
    @OneToMany(mappedBy="pere")
    private Set<Naissance> pere;
}
