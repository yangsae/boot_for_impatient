package dev.yangsae.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Chapter02Application implements CommandLineRunner {

    @Autowired
    ArgumentResolver argumentResolver;
    @Autowired
    Calculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(Chapter02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter 2 numbers like 'a b' : ");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.a(), argument.b());
        System.out.println("result = " + result);
    }
}
