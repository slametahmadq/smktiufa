
package news.webapi.config;

import news.webapi.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Profile(Application.PROFILE_WEB)
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class DevWebConfig extends WebMvcConfigurerAdapter {	
	private final Logger log = LoggerFactory.getLogger(DevWebConfig.class);
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.debug("Configure dev's static web content");
			
		registry.addResourceHandler("/bower_components/**")
				.addResourceLocations("file:webapp/bower_components/");
		registry.addResourceHandler("/**").addResourceLocations("file:webapp/app/");
		
		super.addResourceHandlers(registry);
	}
}
