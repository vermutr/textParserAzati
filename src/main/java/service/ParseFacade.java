package service;

import converter.textParser.Parsable;
import entity.TextComponent;

public class ParseFacade {

    private final Parsable parsable;
    private final TextComponent textComponent;
    private final String text;

    public ParseFacade(Parsable parsable, TextComponent textComponent, String text) {
        this.parsable = parsable;
        this.textComponent = textComponent;
        this.text = text;
    }

    public void parseAndFillData(){
        textComponent.setListOfTextComponents(parsable.doParse(text));
    }


}
