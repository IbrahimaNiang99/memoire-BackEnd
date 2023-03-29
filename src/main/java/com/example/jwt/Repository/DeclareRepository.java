package com.example.jwt.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jwt.Entity.Declare;

public interface DeclareRepository extends JpaRepository<Declare, Long>{
    
}
