package br.com.ifood.vemproifood.dishlist.service;

import br.com.ifood.vemproifood.dishlist.model.CategoryDTO;
import br.com.ifood.vemproifood.dishlist.model.Dish;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishListService {

	private final OpenWeatherService weatherRetriever;
	private final RecomendationService recomendationService;

	@Autowired
	public DishListService(
			final OpenWeatherService openWeatherService,
			final RecomendationService recomendationService) {
		this.weatherRetriever = openWeatherService;
		this.recomendationService = recomendationService;
	}

	public List<Dish> getDishListByCoordinates(Double lat, Double lon){
		Double temperature = this.weatherRetriever.retrieveCurrentTemperatureByCoordinates(lat, lon);
		//TO BE IMPLEMENTED
		CategoryDTO recommendType = recomendationService.getRecommendType("MAPS");

		return new LinkedList<>();
	}

}