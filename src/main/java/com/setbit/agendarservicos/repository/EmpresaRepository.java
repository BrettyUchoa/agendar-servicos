package com.setbit.agendarservicos.repository;

import com.setbit.agendarservicos.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Long> {

}
