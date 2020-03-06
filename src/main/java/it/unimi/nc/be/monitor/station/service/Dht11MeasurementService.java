package it.unimi.nc.be.monitor.station.service;

import java.sql.SQLException;
import java.util.List;

import it.unimi.nc.be.monitor.station.domain.Dht11Measurement;
import it.unimi.nc.be.monitor.station.dto.Dht11Dto;

public interface Dht11MeasurementService {

	void save(Dht11Dto dht11Dto) throws SQLException;
	List<Dht11Measurement> findAll() throws SQLException;
	List<Dht11Dto> findAllAndConvertToDto() throws SQLException;

}
