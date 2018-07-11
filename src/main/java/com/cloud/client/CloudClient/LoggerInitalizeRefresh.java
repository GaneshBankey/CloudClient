package com.cloud.client.CloudClient;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class LoggerInitalizeRefresh implements ApplicationListener<RefreshRemoteApplicationEvent> {

	private static Log log = LogFactory.getLog(LoggerInitalizeRefresh.class);
	@Autowired
    private Environment environment;
	
	private ContextRefresher contextRefresher;

	public LoggerInitalizeRefresh(ContextRefresher contextRefresher) {
		this.contextRefresher = contextRefresher;
	}

	@Override
	public void onApplicationEvent(RefreshRemoteApplicationEvent event) {
		Set<String> keys = contextRefresher.refresh();
		System.err.println(environment.getProperty("app.message"));
		log.info("Received remote refresh request. Keys refreshed " + keys);
	}
}