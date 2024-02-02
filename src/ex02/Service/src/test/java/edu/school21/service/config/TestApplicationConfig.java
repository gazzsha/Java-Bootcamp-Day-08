package edu.school21.service.config;


import edu.school21.entity.User;
import edu.school21.repository.UserRepository;
import edu.school21.repository.UserRepositoryJdbcTemplateImpl;
import edu.school21.service.UserService;
import edu.school21.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class TestApplicationConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("data.sql")
                .build();
    }

    @Bean
    public UserRepository<User> userRepository() {
        return new UserRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }
}
