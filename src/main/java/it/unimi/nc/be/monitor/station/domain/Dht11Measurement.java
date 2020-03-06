package it.unimi.nc.be.monitor.station.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "DHT11_MEASUREMENTS")
public class Dht11Measurement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6021247793673221780L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "MAC_DEVICE_ID")
	@Length(min=0, max=256)
	private String macDeviceId;

	@Column(name = "TEMP")
	@Length(min=0, max=128)
	private String temperature;

	@Column(name = "RH")
	@Length(min=0, max=128)
	private String humidityRel;

	@Column(name="DT_CREATION")
	private Date dtCreation;
	
	public Dht11Measurement() {
		super();
	}
	
	public Dht11Measurement(@Length(min = 0, max = 256) String macDeviceId,
							@Length(min = 0, max = 128) String temperature, 
							@Length(min = 0, max = 128) String humidityRel,
							@Length(min = 0, max = 128) Date dtCreation) {
		super();
		this.macDeviceId = macDeviceId;
		this.temperature = temperature;
		this.humidityRel = humidityRel;
		this.dtCreation = dtCreation;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the macDeviceId
	 */
	public String getMacDeviceId() {
		return macDeviceId;
	}

	/**
	 * @param macDeviceId the macDeviceId to set
	 */
	public void setMacDeviceId(String macDeviceId) {
		this.macDeviceId = macDeviceId;
	}

	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * @return the humidityRel
	 */
	public String getHumidityRel() {
		return humidityRel;
	}

	/**
	 * @param humidityRel the humidityRel to set
	 */
	public void setHumidityRel(String humidityRel) {
		this.humidityRel = humidityRel;
	}

	/**
	 * @return the dtCreation
	 */
	public Date getDtCreation() {
		return dtCreation;
	}

	/**
	 * @param dtCreation the dtCreation to set
	 */
	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}	
	
}
