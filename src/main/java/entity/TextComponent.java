package entity;


import java.util.List;

public class TextComponent {

    private String textComponent;
    private List<TextComponent> listOfTextComponents;

    public TextComponent() {

    }

    public TextComponent(String textComponent) {
        this.textComponent = textComponent;
    }


    public List<TextComponent> getListOfTextComponents() {
        return listOfTextComponents;
    }

    public void setListOfTextComponents(List<TextComponent> listOfTextComponents) {
        this.listOfTextComponents = listOfTextComponents;
    }

    public String getTextComponent() {
        return textComponent;
    }

    public void setTextComponent(String textComponent) {
        this.textComponent = textComponent;
    }

}
