package it.unimi.nc.be.monitor.station.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dateTime")
public class DateTimeController {

	Logger logger = LoggerFactory.getLogger(DateTimeController.class);

	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@PostConstruct
	void init() {
	}
	
	@GetMapping()
	public ResponseEntity<String> getDateTime() {
		Date date = new Date();
		return new ResponseEntity<>(sdf.format(date), HttpStatus.OK);
	}
}
