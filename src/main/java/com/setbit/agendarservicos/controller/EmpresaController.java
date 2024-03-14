package com.setbit.agendarservicos.controller;

import com.setbit.agendarservicos.model.EmpresaModel;
import com.setbit.agendarservicos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")

public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<EmpresaModel> cadastrarEmpresa(@RequestBody EmpresaModel empresaModel) {
        EmpresaModel novaEmpresa = empresaService.salvarEmpresa(empresaModel);
       return new ResponseEntity<>(novaEmpresa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaModel>> listarEmpresas() {
        List<EmpresaModel> empresas = empresaService.listarEmpresas();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaModel> encontrarEmpresaPorId(@PathVariable Long id) {
        return empresaService.encontrarEmpresaPorId(id)
                .map(empresa -> new ResponseEntity<>(empresa, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
