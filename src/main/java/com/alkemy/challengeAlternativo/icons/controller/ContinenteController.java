package com.alkemy.challengeAlternativo.icons.controller;


import com.alkemy.challengeAlternativo.icons.dto.ContinenteDTO;
import com.alkemy.challengeAlternativo.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("continentes")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> getAll(){
        List<ContinenteDTO> continentes = continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }

    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente){
        //guardar continente
        ContinenteDTO continenteGuardado = continenteService.save(continente);

        //devolver 201 xq fue creado y el continente guardado xq va a tener el id de la BD
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteGuardado);
    }
}
