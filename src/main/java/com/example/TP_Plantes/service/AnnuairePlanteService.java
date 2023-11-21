package com.example.TP_Plantes.service;

import com.example.TP_Plantes.model.Plante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnuairePlanteService {

    private List<Plante> plantes = new ArrayList<>();
    private int idCount = 0;

    public  void addPlante(Plante newPlante){

        idCount++;
        newPlante.setId(idCount);
        plantes.add(newPlante);
    }

    public  List<Plante> getPlantes(){
        return plantes;
    }

}
