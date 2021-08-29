package com.unip.tcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unip.tcc.model.HistoricoAgua;

@Repository
public interface HistoricoAguaRepository extends JpaRepository<HistoricoAgua, Integer>{

	
}
