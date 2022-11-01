package dev.yangsae.chapter02;

import dev.yangsae.chapter02.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.io.IOException;

@SpringBootApplication
@Import(AppConfig.class)
public class Chapter02Application {

    public static void main(String[] args) {
        try(ConfigurableApplicationContext context =
                    SpringApplication.run(Chapter02Application.class, args)) {

            Frontend frontend = context.getBean(Frontend.class);
            frontend.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
