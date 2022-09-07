package com.usecase.travel_company_platform.controller;

//import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.travel_company_platform.data.WeatherDataRepository;
import com.usecase.travel_company_platform.data.WeatherInfoData;
//import com.usecase.travel_company_platform.service.WeatherInfoService;

@RestController
public class WeatherInfoController {

	private WeatherDataRepository repository;

	public WeatherInfoController(WeatherDataRepository repository) {
		this.repository = repository;
	}

	@RequestMapping(value = "/weather", method = RequestMethod.GET)
	public List<WeatherInfoData> retrievealldata() {
		return repository.findAll();

	}

	@RequestMapping(value = "/weather", method = RequestMethod.POST)
	public ResponseEntity<WeatherInfoData> addweatherdata(@RequestBody WeatherInfoData weatherInfoData) {

		repository.save(weatherInfoData);

		/*
		 * URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}").buildAndExpand(weatherInfoData.getId()).toUri();
		 */
		return new ResponseEntity<WeatherInfoData>(weatherInfoData, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/weather/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> retrievebyId(@PathVariable Long id) {

		if (!repository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			Optional<WeatherInfoData> weatherinfodata = repository.findById(id);
			return new ResponseEntity<>(weatherinfodata, HttpStatus.OK);
		}

	}

	@RequestMapping(value = "/weather/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletebyId(@PathVariable Long id) {
		if (!repository.existsById(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else {
			repository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}
