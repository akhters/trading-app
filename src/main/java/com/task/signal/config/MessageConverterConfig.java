package com.task.signal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.DeserializationFeature;

@Configuration
public class MessageConverterConfig {

  @Bean
  public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.featuresToDisable(DeserializationFeature.ACCEPT_FLOAT_AS_INT);
    return builder;
  }
}
