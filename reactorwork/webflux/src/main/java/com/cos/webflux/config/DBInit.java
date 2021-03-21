package com.cos.webflux.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import com.cos.webflux.domain.Customer;
import com.cos.webflux.domain.CustomerRepository;

import io.r2dbc.spi.ConnectionFactory;

// schema.sql 파일을 읽어서 실행 시킴
@Configuration
public class DBInit {
	
	@Bean
	public ConnectionFactoryInitializer dbInit(ConnectionFactory connectionFactory) {
		ConnectionFactoryInitializer init = new ConnectionFactoryInitializer();
		init.setConnectionFactory(connectionFactory);
		init.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
		
		return init;
	}
	
	@Bean
	public CommandLineRunner dataInit(CustomerRepository customerRepository) {
		return (args) -> { // run함수 실행
			// 데이터 초기화 하기
			customerRepository.saveAll(Arrays.asList(
					new Customer("Jack", "Bauer"),
					new Customer("Choi", "Bauer"),
					new Customer("Hong", "Bauer"),
					new Customer("Han", "Bauer"),
					new Customer("Nam", "Bauer"),
					new Customer("Chung", "Bauer")
					)
					).blockLast();
		};
	}
	
}
