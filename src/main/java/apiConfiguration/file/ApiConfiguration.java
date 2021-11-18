package apiConfiguration.file;

import converter.file.impl.ConverterTxtFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ApiConfiguration {

    public FileReader configureFile(final String path) {
        try {
            return new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BufferedReader bufferedReader(final FileReader fileReader){
        return new BufferedReader(fileReader);
    }

    public ConverterTxtFile converterTxtFile(final BufferedReader bufferedReader){
        return new ConverterTxtFile(bufferedReader);
    }


}
