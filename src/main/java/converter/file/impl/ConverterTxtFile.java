package converter.file.impl;


import converter.file.FileConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ConverterTxtFile implements FileConverter {

    private final BufferedReader file;

    public ConverterTxtFile(final BufferedReader file) {
        this.file = file;
    }

    @Override
    public String convertFile() {
        try (file) {
            return file.lines().collect(Collectors.joining(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}
