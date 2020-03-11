package it.unimi.nc.be.monitor.station.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import it.unimi.nc.be.monitor.station.domain.Dht11Measurement;
import it.unimi.nc.be.monitor.station.dto.Dht11Dto;
import it.unimi.nc.be.monitor.station.repository.Dht11MeasurementRepository;
import it.unimi.nc.be.monitor.station.service.Dht11MeasurementService;


@Service("LogsService")
public class Dht11MeasurementServiceImpl implements Dht11MeasurementService {

	Logger logger = LoggerFactory.getLogger(Dht11MeasurementServiceImpl.class);
	
	@Autowired
	Dht11MeasurementRepository dht11MeasurementRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void save(Dht11Dto dht11Dto) throws SQLException {

		logger.info("storing device mac " + dht11Dto.getMacDeviceId() + " temp " + dht11Dto.getTemperature() + " rh% " + dht11Dto.getHumidityRel());
		try {
			Dht11Measurement entity = modelMapper.map(dht11Dto, Dht11Measurement.class);						
			entity.setDtCreation(new Date());
			dht11MeasurementRepository.save(entity);
		} catch (Exception e) {
			throw new SQLException("failed to store dht11 measurement into db. Err: " + e.getMessage());
		}
	}

	@Override
	public List<Dht11Measurement> findAll() throws SQLException {

		try {
			PageRequest pageable = PageRequest.of(0, 100, Direction.DESC, "dtCreation");
			Page<Dht11Measurement> entities = dht11MeasurementRepository.findAll(pageable);
			List<Dht11Measurement> pageContent = entities.getContent();
			Collections.reverse(pageContent);
			return pageContent;
		} catch (Exception e) {
			StringBuilder errMsg = new StringBuilder("failed to retrieve dht11 measurement from db. Err: " + e.getMessage());
			logger.info(errMsg.toString());
			throw new SQLException(errMsg.toString());
		}
	}

	@Override
	public List<Dht11Dto> findAllAndConvertToDto() throws SQLException {
		List<Dht11Measurement> entities = findAll();
		List<Dht11Dto> dtos = null;
		
		if (entities == null)
			throw new SQLException("no data stored");			
		else
			//dtos = entities.stream().map(e -> modelMapper.map(e,Dht11Dto.class)).collect(Collectors.toList());
			dtos = entities.stream()
						   .map(e -> new Dht11Dto(e.getMacDeviceId(), e.getTemperature(), e.getHumidityRel(), e.getDtCreation().toString()))
						   .collect(Collectors.toList());
			
		if (dtos == null)
			throw new SQLException("data conversion failed");
		
		return dtos;
	}
}
