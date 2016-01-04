
package org.meruvian.yama.web.security.oauth;

import java.util.HashMap;

import javax.inject.Inject;

import org.meruvian.yama.core.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class DefaultOauthApplications extends HashMap<String, Application> {
	private static Logger log = LoggerFactory.getLogger(DefaultOauthApplications.class);
	
	@Inject
	private void setEnvironment(Environment env) {
		log.info("Configure default oauth2 clients");

		RelaxedPropertyResolver props = new RelaxedPropertyResolver(env, "rest.");
		
		String key = null;
		for (int i = 0; props.containsProperty((key = "clients[" + i + "]") + ".id"); i++) {
			String appId = props.getProperty(key + ".id");
			
			Application application = new Application();
			application.setId(appId);
			application.setSecret(props.getProperty(key + ".secret"));
			application.setRegisteredRedirectUri(props.getProperty(key + ".redirect"));
			application.setAutoApprove(true);
			
			put(appId, application);
			
			log.info("Application ID: {}", appId);
		}
	}
}
