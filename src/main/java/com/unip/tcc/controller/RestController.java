package com.unip.tcc.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unip.tcc.model.HistoricoAgua;
import com.unip.tcc.repository.HistoricoAguaRepository;
import com.unip.tcc.resource.RequestHistoricoAgua;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
	
	private final HistoricoAguaRepository historicoAguaRepository;

	public RestController(HistoricoAguaRepository historicoAguaRepository) {
		this.historicoAguaRepository = historicoAguaRepository;
	}
	
	@PostMapping(value="/salvar")
	@ResponseBody
	public String insereBanco(@RequestBody RequestHistoricoAgua request) {
		HistoricoAgua historicoAgua = new HistoricoAgua();
		
		
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        
        Instant instant = zdt.toInstant();
        
        Date date = Date.from(instant);
		
        historicoAgua.setData(date);
		
		historicoAgua.setQuantidadeLitrosHora(request.getHora());
		historicoAgua.setQuantidadeLitrosTotal(request.getTotal());
		
		historicoAguaRepository.save(historicoAgua);
		return "Inserido no Banco";
	}
}
