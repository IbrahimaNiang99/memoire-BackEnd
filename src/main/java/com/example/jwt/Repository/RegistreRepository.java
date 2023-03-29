package com.example.jwt.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jwt.Entity.Registre;
public interface RegistreRepository extends JpaRepository<Registre, Long> {
    
    //Optional<Registre> findById(Long id);
}
