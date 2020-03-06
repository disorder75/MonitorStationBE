package it.unimi.nc.be.monitor.station.configuration;

import java.util.Date;

import org.aspectj.weaver.World.TypeMap;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import it.unimi.nc.be.monitor.station.domain.Dht11Measurement;
import it.unimi.nc.be.monitor.station.dto.Dht11Dto;

@Configuration
public class RestConfig {

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    @Bean
    public ModelMapper modelMapper() {
    	ModelMapper mm = new ModelMapper();
    	mm.getConfiguration().setAmbiguityIgnored(true);
    	/* ignore this fields during conversion  */
    	mm.typeMap(Dht11Dto.class,Dht11Measurement.class).addMappings(mapper -> {
            mapper.skip(Dht11Measurement::setId);
        });
    	
    	/* configure here the mapper for date conversion.
    	 * now it's done manually into the service layer, quick & dirt*/
   	
        return mm;
    }
}