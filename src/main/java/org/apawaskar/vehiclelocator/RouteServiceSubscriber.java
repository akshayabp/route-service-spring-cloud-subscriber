package org.apawaskar.vehiclelocator;

import org.apawaskar.vehiclelocator.services.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableBinding(Sink.class)
@SpringBootApplication
@EnableEurekaClient
public class RouteServiceSubscriber {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RouteServiceSubscriber.class);
	
	@Autowired
	private RouteService routeService;
	
	@LoadBalanced
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(RouteServiceSubscriber.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void log(String msg) {
		LOGGER.info("Message recieved at route-service subscriber: {}", msg);
		routeService.updateRoute(msg);
	}
}
