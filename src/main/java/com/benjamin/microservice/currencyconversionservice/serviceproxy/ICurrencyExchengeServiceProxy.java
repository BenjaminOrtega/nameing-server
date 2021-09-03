package com.benjamin.microservice.currencyconversionservice.serviceproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.benjamin.microservice.currencyconversionservice.model.CurrencyConversion;


@FeignClient(name = "currency-exchange-service", url = "localhost:8003")
//@FeignClient(name = "currency-exchange-service")
//@LoadBalancerClient(name = "currency-exchange-service", configuration = CurrencyConversionServiceConfiguration.class)
public interface ICurrencyExchengeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveCurrencyConversion(@PathVariable String from, @PathVariable String to );

}
