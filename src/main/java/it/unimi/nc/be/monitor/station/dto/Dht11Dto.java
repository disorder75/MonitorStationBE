package it.unimi.nc.be.monitor.station.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Dht11Dto {

	@NotNull
	@Length(min=0, max=256)
	private String macDeviceId;

	@NotNull
	@Length(min=0, max=128)
	private String temperature;

	@NotNull
	@Length(min=0, max=128)
	private String humidityRel;

	@Length(min=0, max=128)
	private String date;
	
	public Dht11Dto(@NotNull @Length(min = 0, max = 256) String macDeviceId,
					@NotNull @Length(min = 0, max = 128) String temperature,
					@NotNull @Length(min = 0, max = 128) String humidityRel,
					@Length(min = 0, max = 128) String date) {
		super();
		this.macDeviceId = macDeviceId;
		this.temperature = temperature;
		this.humidityRel = humidityRel;
		this.date = date;
	}

	public Dht11Dto() {
		super();
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
