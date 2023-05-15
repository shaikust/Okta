package com.example.sample.config;

import com.example.sample.audit.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
@EnableMongoAuditing(auditorAwareRef="auditorProvider")
public class MongoConfig {

	   @Bean
	    AuditorAware<String> auditorProvider() {
	        return new AuditorAwareImpl();
	    }
//  @Bean
//  public ValidatingMongoEventListener validatingMongoEventListener() {
//    return new ValidatingMongoEventListener(validator());
//  }
//
//  @Bean
//  public LocalValidatorFactoryBean validator() {
//    return new LocalValidatorFactoryBean();
//  }

}
