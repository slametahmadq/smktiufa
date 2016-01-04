
package news.webapi.config;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.tuckey.web.filters.urlrewrite.Conf;
import org.tuckey.web.filters.urlrewrite.UrlRewriteFilter;

@Configuration
@AutoConfigureAfter(DispatcherServletAutoConfiguration.class)
public class WebConfig extends WebMvcConfigurerAdapter {	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Inject
	private ResourceLoader resourceLoader;
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		log.debug("Configure view controllers");
		super.addViewControllers(registry);
		
		registry.addViewController("/login").setViewName("forward:/login.html");
		registry.addViewController("/register").setViewName("forward:/register.html");
		registry.addRedirectViewController("/oauth/approval", "/oauth_approval").setKeepQueryParams(true);
		registry.addViewController("/oauth_approval").setViewName("forward:/oauth_approval.html");
	}
	
	/*
	 * URL Rewrite for angularjs html5mode
	 */
	@Bean
	public FilterRegistrationBean urlRewriteFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean(new UrlRewriteFilter() {
			@Override
			protected void loadUrlRewriter(FilterConfig filterConfig) throws ServletException {
				try {
					Conf conf = new Conf(resourceLoader.getResource("classpath:/urlrewrite.xml").getURL());
					checkConf(conf);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		filter.addInitParameter("logLevel", "slf4j");
		
		return filter;
	}
}
