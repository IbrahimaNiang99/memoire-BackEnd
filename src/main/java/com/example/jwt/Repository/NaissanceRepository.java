package com.example.jwt.Repository;
import com.example.jwt.Entity.Naissance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NaissanceRepository extends JpaRepository<Naissance, Long>{
    
}
