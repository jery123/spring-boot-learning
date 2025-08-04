package com.popcode.springcoredemo.config;

import com.popcode.springcoredemo.common.Coach;
import com.popcode.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

        @Bean("aquatic")
        public Coach swimCoach(){
            return new SwimCoach();
        }
}
