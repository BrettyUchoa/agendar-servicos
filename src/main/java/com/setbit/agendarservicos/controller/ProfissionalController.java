package com.setbit.agendarservicos.controller;

import com.setbit.agendarservicos.model.ProfissionalModel;
import com.setbit.agendarservicos.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalModel> cadastrarProfissional(@RequestBody ProfissionalModel profissional) {
        ProfissionalModel novoProfissional = profissionalService.salvarProfissional(profissional);
        return new ResponseEntity<>(novoProfissional, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalModel>> listarProfissionais() {
        List<ProfissionalModel> profissionais = profissionalService.listarProfissionais();
        return new ResponseEntity<>(profissionais, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalModel> encontrarProfissionalPorId(@PathVariable Long id) {
        return profissionalService.encontrarProfissionalPorId(id)
                .map(profissional -> new ResponseEntity<>(profissional, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Long id) {
        profissionalService.deletarProfissional(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
