package dev.yangsae.chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderArgumentResolver implements ArgumentResolver {
    @Override
    public Argument resolve(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        return new Argument(a, b);
    }
}
