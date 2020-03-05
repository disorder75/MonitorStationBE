package it.unimi.nc.be.monitor.station.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/*
 *		Facilities for non spring classes that requires beans from
 *		runtime context 
 */
@Configuration
public class BotContextAware implements ApplicationContextAware {

	private final Logger LOGGER = LoggerFactory.getLogger(BotContextAware.class);
	
	static ApplicationContext applicationContext = null;
		
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;		
	}
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}

}
