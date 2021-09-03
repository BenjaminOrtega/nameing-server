package com.benjamin.microservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.benjamin.microservice.currencyconversionservice.model.CurrencyConversion;
import com.benjamin.microservice.currencyconversionservice.serviceproxy.ICurrencyExchengeServiceProxy;

@RestController
public class CurrencyConverterController {
	
	@Autowired
	private ICurrencyExchengeServiceProxy iCurrencyExchengeServiceProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		/*Forma manual para obtener contenido de un microservicio o apiRestFull
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", //obtiene la key("from") del Map para agregar el valor del path({from})
				CurrencyConversion.class, 
				uriVariables);//aqui contiene las key´s ("from") para pasar el valor en el path({from})
		
		CurrencyConversion response = responseEntity.getBody();*/
		
		
		//usando openFeign
		CurrencyConversion response = iCurrencyExchengeServiceProxy.retrieveCurrencyConversion(from, to);
		
		return new CurrencyConversion(response.getId(), from, to,response.getConversionMultiple(), 
				quantity,quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}
