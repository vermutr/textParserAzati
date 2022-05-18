import apiConfiguration.file.ApiConfiguration;
import converter.file.FileConverter;
import converter.textParser.Parsable;
import converter.textParser.impl.ParserText;
import entity.FullTextComponent;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        ApiConfiguration apiConfiguration = new ApiConfiguration();

        String path = "D:\\garbage\\textToConvert.txt";

        FileReader fileReader = apiConfiguration.configureFile(path);
        BufferedReader bufferedReader = apiConfiguration.bufferedReader(fileReader);
        FileConverter fileConverter = apiConfiguration.converterTxtFile(bufferedReader);

        String text = fileConverter.convertFile();
        FullTextComponent fullTextComponent = apiConfiguration.fullTextComponent(text);
        Parsable parsable = apiConfiguration.parsable();
        parsable.doParse(fullTextComponent);


        System.out.println("\n");
    }

}
