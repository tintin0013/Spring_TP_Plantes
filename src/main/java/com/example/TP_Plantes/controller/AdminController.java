package com.example.TP_Plantes.controller;

import com.example.TP_Plantes.model.Plante;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.TP_Plantes.service.AnnuairePlanteService;

@RestController
@RequestMapping("admin")
public class AdminController {


    @Autowired
    private AnnuairePlanteService annuairePlanteService;

    @PostMapping("plantes")
    public ResponseEntity addPersonne(@RequestBody Plante newPlante) {
        if(newPlante.getNom() == null || newPlante.getCouleur() == null || newPlante.getNom().isBlank() || newPlante.getCouleur().isBlank()){
            return ResponseEntity.status(404).body("erreur d' ajout de plante. Specifié des données valides.");

        }
        annuairePlanteService.addPlante(newPlante);
        return ResponseEntity.ok("Plante ajouté avec succée");

    }


    @PutMapping("plantes/{id}")
    public ResponseEntity<String> updatePersonne(@RequestBody Plante newData, @PathVariable("id") Integer id){
        int index = 0;
        while(index < annuairePlanteService.getPlantes().size() && !annuairePlanteService.getPlantes().get(index).getId().equals(id))
            index++;
        if(index < annuairePlanteService.getPlantes().size()){
            annuairePlanteService.getPlantes().set(index,newData);
            return ResponseEntity.ok("Plante modifié avec succée");
        }
        else {
            return ResponseEntity.status(404).body("erreur de modification. Specifié un ID valide.");
        }
    }

    @DeleteMapping("plantes/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        int index = 0;
        while(index < annuairePlanteService.getPlantes().size() && !annuairePlanteService.getPlantes().get(index).getId().equals(id))
            index++;
        if(index < annuairePlanteService.getPlantes().size()){
            annuairePlanteService.getPlantes().remove(index);
            return ResponseEntity.ok("Plante supprimé avec succée");
        }
        else {
            return ResponseEntity.status(404).body("erreur de suppression. Specifié un ID valide.");
        }

    }
}

