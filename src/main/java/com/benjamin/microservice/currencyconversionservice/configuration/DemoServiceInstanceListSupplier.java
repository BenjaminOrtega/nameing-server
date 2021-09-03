package com.benjamin.microservice.currencyconversionservice.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;


import reactor.core.publisher.Flux;

public class DemoServiceInstanceListSupplier implements ServiceInstanceListSupplier{

	private final String serviceId;
	
	//se obtiene el id del servicio
	public DemoServiceInstanceListSupplier(String serviceId) {
		this.serviceId = serviceId;
	}
	
	//se configuran las instancias del servicio que se va a consumir
	@Override
	public Flux<List<ServiceInstance>> get() {
	
		return Flux.just(
					Arrays.asList(
								new DefaultServiceInstance(serviceId + "1", serviceId, "localhost", 8001, false),
								new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8002, false),
								new DefaultServiceInstance(serviceId + "2", serviceId, "localhost", 8000, false)
							)
				);
	}

	@Override
	public String getServiceId() {
		
		return serviceId;
	}

}
