package com.nubank.capitalgains.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class FileReaderUtil {

    private BufferedReader reader;

    public FileReaderUtil(InputStream inputStream) {
        InputStreamReader streamReader =
                new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        reader = new BufferedReader(streamReader);
    }

    public String next() throws IOException {
        Optional<String> line = Optional.ofNullable(reader.readLine());
        return line.orElseGet(() -> line.orElse(""));
    }
}
