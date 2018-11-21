package br.com.ifood.vemproifood.dishlist.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.ImmutableMap;

import br.com.ifood.vemproifood.dishlist.model.GoogleMapsResponse;
import br.com.ifood.vemproifood.dishlist.model.GoogleMapsResponse.AddressComponents;

@Service
public class GoogleMapsRetrieverService {

	static final String MAPS_URL = "https://maps.googleapis.com/maps/api/geocode/json";

	@Resource
	private RestTemplate restTemplate;
	@Value("${googlemaps.api.key}")
	private String apiKey;

	public String retrieveCityByCoordinates(final double latitude,
		      final double longitude) {
	    final ResponseEntity<GoogleMapsResponse> googleMapsDataResponse = restTemplate.getForEntity(
	    		MAPS_URL + "?latlng={latitude},{longitude}&key={apiKey}&location=ROOFTOP",
	    		GoogleMapsResponse.class,
	            ImmutableMap.of(
	                "latitude", latitude,
	                "longitude", longitude,
	                "apiKey", apiKey));

		AddressComponents result = googleMapsDataResponse.getBody().getResults().get(0);
		return result.getAdressComponents().stream().filter(ad -> ad.getTypes().contains("administrative_area_level_2")).findFirst().get().getLong_name();
	}
}
