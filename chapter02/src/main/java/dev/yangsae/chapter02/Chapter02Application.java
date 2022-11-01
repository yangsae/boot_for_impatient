package dev.yangsae.chapter02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
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
