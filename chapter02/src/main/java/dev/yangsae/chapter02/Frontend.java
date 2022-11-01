package dev.yangsae.chapter02;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class Frontend {

    @Autowired
    ArgumentResolver argumentResolver;
    @Autowired
    Calculator calculator;

    public void run() throws IOException {
        System.out.println("Enter 2 numbers like 'a b' : ");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.a(), argument.b());
        System.out.println("result = " + result);
    }
}
