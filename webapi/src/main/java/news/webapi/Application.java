
package news.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.social.SocialWebAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SocialWebAutoConfiguration.class })
@ComponentScan({ "org.meruvian.yama", "tot.news", "news" })
public class Application {
	public static final String PROFILE_DEV = "dev";
	public static final String PROFILE_PROD = "prod";
	public static final String PROFILE_WEB = "web";
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.setShowBanner(false);
		
		application.run(args);
	}
}
