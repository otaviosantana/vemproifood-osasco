package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.Dish;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishListService {

	private final OpenWeatherService weatherRetriever;
	private final GoogleMapsRetrieverService mapsService;

	@Autowired
	public DishListService(
			OpenWeatherService openWeatherService, GoogleMapsRetrieverService mapsService) {
		this.weatherRetriever = openWeatherService;
		this.mapsService = mapsService;
	}

	public List<Dish> getDishListByCoordinates(Double lat, Double lon){
		Double temperature = this.weatherRetriever.retrieveCurrentTemperatureByCoordinates(lat, lon);

		String city = this.mapsService.retrieveCityByCoordinates(lat, lon);

		return new LinkedList<>();
	}

}