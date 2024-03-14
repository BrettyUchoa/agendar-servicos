package com.setbit.agendarservicos.service;

import com.setbit.agendarservicos.model.ProfissionalModel;
import com.setbit.agendarservicos.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public ProfissionalModel salvarProfissional(ProfissionalModel profissional) {
        return profissionalRepository.save(profissional);
    }

    public List<ProfissionalModel> listarProfissionais()
    {
        return profissionalRepository.findAll();
    }

    public Optional<ProfissionalModel> encontrarProfissionalPorId(Long id) {
        return profissionalRepository.findById(id);
    }

    public void deletarProfissional(Long id) {
        profissionalRepository.deleteById(id);
    }
}
