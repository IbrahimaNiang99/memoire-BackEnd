package com.example.jwt.Repository;
import com.example.jwt.Entity.StructureSanitaire;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StructureSaniRepository extends JpaRepository<StructureSanitaire, Long>{
    
}
