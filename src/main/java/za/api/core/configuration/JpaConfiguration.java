package za.api.core.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import za.api.core.model.user.User;
import za.api.core.service.auditing.AuditorAwareServiceImpl;

/**
 * Created by Azael on 2017/08/28.
 */
@Configuration
@EnableJpaAuditing
public class JpaConfiguration {
    @Autowired
    private Environment environment;

    @Bean(name = "dataSource")
    @Primary
    public BasicDataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/core?useSSL=false");
        basicDataSource.setUsername("core");
        basicDataSource.setPassword("core");
        basicDataSource.setTestWhileIdle(true);
        basicDataSource.setValidationQuery("SELECT 1");
        return basicDataSource;
    }

    @Bean
    public AuditorAware<User> auditorProvider() {
        return new AuditorAwareServiceImpl();
    }
}
