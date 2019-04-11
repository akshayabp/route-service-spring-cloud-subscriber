package org.apawaskar.vehiclelocator.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apawaskar.vehiclelocator.domain.Location;
import org.apawaskar.vehiclelocator.domain.Log;
import org.apawaskar.vehiclelocator.domain.Logfeed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void updateRoute(String logFeedStr) {
		
		Logfeed feed = getLogfeed(logFeedStr);
		
		String routeId = feed.getRouteId();
		
		Log log = constructLog(feed);
		
		String logStr = getLog(log);
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
		
		HttpEntity<String> request = new HttpEntity<>(logStr ,headers);
		
		Map<String, Object> params = new HashMap<>();
		params.put("id",routeId);
		
		restTemplate.exchange(
                 "http://route-service/route/{id}/log",
                 HttpMethod.PUT,
                 request, String.class, params);

	}
	
	private Log constructLog(Logfeed logFeed){
		Log log = new Log();
		
		Location location = new Location();
		location.setLatitute(logFeed.getLatitute());
		location.setLongitude(logFeed.getLongitude());
				
		log.setLocation(location);		
		return log;
		
	}
	
	private String getLog(Log log){
		String logStr = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			logStr =objectMapper.writeValueAsString(log);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logStr;
	}
	
	private Logfeed getLogfeed(String logFeedStr){
		Logfeed feed = null;
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			feed = objectMapper.readValue(logFeedStr, Logfeed.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return feed;
	}

}
