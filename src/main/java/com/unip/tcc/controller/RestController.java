package com.unip.tcc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unip.tcc.model.WaterHistory;
import com.unip.tcc.repository.WaterHistoryRepository;
import com.unip.tcc.resource.ResponseConsumation;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
	
	private final WaterHistoryRepository waterHistoryRepository;

	public RestController(WaterHistoryRepository historicoAguaRepository) {
		this.waterHistoryRepository = historicoAguaRepository;
	}
	
	@PostMapping(value="save")
	@ResponseBody
	public ResponseEntity<String> saveWaterHistory(@RequestParam(name = "quantity") Double quantity) {
		
		
        WaterHistory waterHistoryToday = waterHistoryRepository.retreiveToday();
        
        if(waterHistoryToday == null) {
        	//waterHistoryToday = new WaterHistory(quantity);
        	waterHistoryRepository.saveByQuantity(quantity);
        }
        else {
        	waterHistoryToday.setQuantity(waterHistoryToday.getQuantity() + quantity);
        	waterHistoryRepository.flush();
        }
       
		return new ResponseEntity<>("Sucess to persist !", HttpStatus.OK);
	}
	
	@GetMapping(value="consumation")
	@ResponseBody
	public ResponseEntity<Object> consumationHistory(){
		
		WaterHistory waterHistoryToday = waterHistoryRepository.retreiveToday();
		
		WaterHistory waterHistoryYesterday = waterHistoryRepository.retreiveYesterday();
		
		List<WaterHistory> listWaterHistoryWeek = waterHistoryRepository.retreiveWeek();

		String qtyToday = "0";
		
		String qtyYesterday = "0";
		
		if(waterHistoryToday != null)
			qtyToday = waterHistoryToday.getQuantity().toString();
		
		if(waterHistoryYesterday != null)
			qtyYesterday = waterHistoryYesterday.getQuantity().toString();
		
		ResponseConsumation response = new ResponseConsumation(qtyToday, qtyYesterday, listWaterHistoryWeek);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
