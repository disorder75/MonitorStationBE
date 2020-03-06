package it.unimi.nc.be.monitor.station.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.unimi.nc.be.monitor.station.domain.Dht11Measurement;

@Repository
@Transactional
public interface Dht11MeasurementRepository extends JpaRepository<Dht11Measurement, Long> {

}