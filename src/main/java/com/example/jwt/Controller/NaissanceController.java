package com.example.jwt.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.example.jwt.Repository.NaissanceRepository;
import com.example.jwt.Entity.*;
import com.example.jwt.Service.NaissService.*;
import java.util.Optional;
import com.example.jwt.Dto.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaissanceController {

    private final NaissanceRepository naissanceRepository;

    @Autowired
    private NaissService naissService;

    public NaissanceController(NaissanceRepository naissanceRepository){
        this.naissanceRepository = naissanceRepository;
    }
//ResponseEntity<Naissance>
    @PostMapping("/naissance/ajout")
    public ResponseEntity<Naissance> ajout(@RequestBody Naissance request){
        
        // naissService.ajoutDeclaration(request.getActe(), request.getDeclarant() , request.getPere(), request.getMere() ,
        //  request.getDeclare(), request.getRegistre(), request.getStructureSanitaire());
        // // System.out.println(request);
        // System.out.println(request);

        // return ResponseEntity.ok().build();
        if(request.getTypeDeclaration() =="Normale"){
            request.getJugement().setId(null);
            System.out.println("ici c barça");
            
        }
        return new ResponseEntity<Naissance>(naissanceRepository.save(request), HttpStatus.CREATED) ;
        //System.out.println(request.getDeclarant());
        //naissanceRepository.save(request);

    }
    /*
     * return new ResponseEntity<Formationsanitaire>(formationSanitaireRepository.save(formationsanitaire), HttpStatus.CREATED) ;
 
     */

    @GetMapping("/naissance/liste")
    public List<Naissance> list(){
        return naissanceRepository.findAll();
    }

    @GetMapping("/naissance/getById/{id}")
    public Naissance getById(@PathVariable Long id) throws Exception{
        Optional<Naissance> naiss = naissanceRepository.findById(id);
        if (naiss.isPresent()){
            return naiss.get();
        }else {
            throw new Exception("Cette declaration n'existe pas dans la BDD");
        }
    }
    
}
