package it.unimi.nc.be.monitor.station.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

	public static final String ECHO = "echo";

	Logger logger = LoggerFactory.getLogger(EchoController.class);

	@PostMapping(consumes = "application/json" )
	public ResponseEntity<List<Object>> echo(@RequestBody() List<Object> objects) {
		return new ResponseEntity<>(objects, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
}
