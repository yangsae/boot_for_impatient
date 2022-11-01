package dev.yangsae.chapter02;

import java.io.IOException;
import java.io.InputStream;

public interface ArgumentResolver {
    Argument resolve(InputStream inputStream) throws IOException;
}
