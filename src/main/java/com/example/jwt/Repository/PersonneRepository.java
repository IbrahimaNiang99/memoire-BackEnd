package com.example.jwt.Repository;

import com.example.jwt.Entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
    
}
