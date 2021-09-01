package com.unip.tcc.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(value="salvar")
	@ResponseBody
	public ResponseEntity<String> insereBanco(@RequestBody RequestHistoricoAgua request) {
		
		//diminuindo 3 horas do dia por conta do servidor EUA
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, -3);
        Instant instant = calendar.toInstant();
        Date date = Date.from(instant);
        
        HistoricoAgua historicoAgua = new HistoricoAgua();

        historicoAgua.setData(date);
		historicoAgua.setQuantidadeLitrosHora(request.getHora());
		historicoAgua.setQuantidadeLitrosTotal(request.getTotal());
		
		historicoAguaRepository.save(historicoAgua);
		
		return new ResponseEntity<>("Inserido no Banco", HttpStatus.OK);
	}
}
