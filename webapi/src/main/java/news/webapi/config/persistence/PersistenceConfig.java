
package news.webapi.config.persistence;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan({ "org.meruvian.yama", "tot.news", "news" })
@EnableJpaRepositories({ "org.meruvian.yama", "tot.news", "news" })
public class PersistenceConfig {
}
