package com.nc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nc.lang.Language;
import com.nc.lang.impl.English;

@Configuration
@ComponentScan({"com.nc.bean"})
public class AppConfig {
	@Bean(name="languagez")
	public Language setLang() {
		return new English();
	}
}
