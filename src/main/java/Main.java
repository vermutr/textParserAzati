import apiConfiguration.file.ApiConfiguration;
import converter.file.FileConverter;
import converter.textParser.impl.ParserText;
import entity.TextComponent;
import service.ParseFacade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApiConfiguration apiConfiguration = new ApiConfiguration();

        String path = "D:\\garbage\\textToConvert.txt";

        FileReader fileReader = apiConfiguration.configureFile(path);
        BufferedReader bufferedReader = apiConfiguration.bufferedReader(fileReader);
        FileConverter fileConverter = apiConfiguration.converterTxtFile(bufferedReader);

        String text = fileConverter.convertFile();

        TextComponent textComponent = new TextComponent();

        ParseFacade parseFacade = new ParseFacade(new ParserText(), textComponent, text);
        parseFacade.parseAndFillData();

        List<TextComponent> listOfTextComponents = textComponent.getListOfTextComponents();
        listOfTextComponents.forEach(n-> System.out.println(n.getTextComponent()));

    }

}
