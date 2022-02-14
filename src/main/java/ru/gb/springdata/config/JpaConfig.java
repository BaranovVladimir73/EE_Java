package ru.gb.springdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.gb.springdata.repository")
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class JpaConfig {


    @Bean
    public AuditorAware<String> auditorAwareBean() {
        return () -> Optional.of("User");
    }
}
