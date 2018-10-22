package br.com.dcb.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigsApplication.class, args);
	}
}
