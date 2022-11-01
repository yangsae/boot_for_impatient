package dev.yangsae.chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    Calculator calculator() {
        return new AddCalculator();
    }

    @Bean
    ArgumentResolver argumentResolver() {
        return new BufferedReaderArgumentResolver();
    }
}
