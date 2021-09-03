package com.benjamin.microservice.currencyconversionservice.configuration;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Configuracion para otener listas de instancias de servicios
@Configuration
public class CurrencyConversionServiceConfiguration {

	//metodo para obtener la lista de instancias de la clase DemoServiceInstanceListSupplier
	@Bean
	@Primary
	ServiceInstanceListSupplier serviceInstanceListSupplier() {
		return new DemoServiceInstanceListSupplier("currency-exchange-service");
	}
}
