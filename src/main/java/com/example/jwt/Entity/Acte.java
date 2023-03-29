package com.example.jwt.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    protected Long id;
    protected Long numeroActe;
    protected Date dateDeclaration;
    protected String typeDeclaration;

}
