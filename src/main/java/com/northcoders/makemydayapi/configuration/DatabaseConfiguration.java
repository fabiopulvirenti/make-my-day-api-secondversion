package com.northcoders.makemydayapi.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:database.properties")
public class DatabaseConfiguration {
}
