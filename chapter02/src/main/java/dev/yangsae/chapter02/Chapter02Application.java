package dev.yangsae.chapter02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SpringBootApplication
@Import(AppConfig.class)
public class Chapter02Application {

    public static void main(String[] args) {
        try(ConfigurableApplicationContext context =
                    SpringApplication.run(Chapter02Application.class, args)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter 2 numbers like 'a b' : ");
            String[] inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);

            Calculator calculator = context.getBean(Calculator.class);
            int result = calculator.calc(a, b);

            System.out.println("result = " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
