package it.unimi.nc.be.monitor.station.controller;

import java.sql.SQLException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.unimi.nc.be.monitor.station.dto.Dht11Dto;
import it.unimi.nc.be.monitor.station.service.Dht11MeasurementService;

@RestController
@RequestMapping("/dht11")
public class Dht11Controller {

	Logger logger = LoggerFactory.getLogger(Dht11Controller.class);

	@Autowired
	Dht11MeasurementService dht11MeasurementService;
	
	@PostMapping(consumes = "application/json" )
	public ResponseEntity<String> saveMeasurement(@RequestBody() Dht11Dto dht11Dto) {
		try {
			dht11MeasurementService.save(dht11Dto);
			return new ResponseEntity<>("measurements correctly saved for device " + dht11Dto.getMacDeviceId(), HttpStatus.OK);
		} catch (SQLException e) {
			return new ResponseEntity<>("impossible to save data. Err: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<List<Dht11Dto>> getMeasurements() {
		
		try {
			List<Dht11Dto> ret = dht11MeasurementService.findAllAndConvertToDto();
			return new ResponseEntity<>(ret, HttpStatus.OK);

		} catch (SQLException e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
