package com.example.TP_Plantes.controller;

import com.example.TP_Plantes.model.Plante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TP_Plantes.service.AnnuairePlanteService;

import java.util.List;

@RestController
@RequestMapping("api")
public class PlanteController {

    @Autowired
    private AnnuairePlanteService annuairePlanteService;

    @GetMapping("plantes")
    public ResponseEntity<?> getPersonnes(){
        if (annuairePlanteService.getPlantes().isEmpty()){
            return ResponseEntity.status(404).body("La liste de plantes est vide");
        }

        return ResponseEntity.ok(annuairePlanteService.getPlantes());
    }

    @GetMapping("plantes/{id}")
    public ResponseEntity<?> getPersonne(@PathVariable("id") Integer id){
        for(Plante p : annuairePlanteService.getPlantes()){
            if(p.getId().equals(id))
                return ResponseEntity.ok(p);
        }
        return ResponseEntity.status(404).body("Plante avec l'ID " + id + " non trouvée");
    }


}
