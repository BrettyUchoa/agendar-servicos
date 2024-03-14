package com.setbit.agendarservicos.service;

import com.setbit.agendarservicos.model.EmpresaModel;
import com.setbit.agendarservicos.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaModel salvarEmpresa(EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    public List<EmpresaModel> listarEmpresas()
    {
        return empresaRepository.findAll();

    }

    public Optional<EmpresaModel> encontrarEmpresaPorId(Long id) {
        return empresaRepository.findById(id);
    }

    public void deletarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}
