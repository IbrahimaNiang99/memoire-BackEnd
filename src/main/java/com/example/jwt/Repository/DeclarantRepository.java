package com.example.jwt.Repository;

import com.example.jwt.Entity.Declarant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclarantRepository extends JpaRepository<Declarant, Long> {
}
