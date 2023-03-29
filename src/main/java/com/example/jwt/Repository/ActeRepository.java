package com.example.jwt.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jwt.Entity.Acte;
public interface ActeRepository extends JpaRepository<Acte, Long>{
    
}
