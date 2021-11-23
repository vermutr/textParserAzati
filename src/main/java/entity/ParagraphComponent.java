package entity;



import java.util.List;

public class ParagraphComponent {

    private List<SentenceComponent> sentenceComponentList;
    private String paragraph;

    public ParagraphComponent(final String paragraph) {
        this.paragraph = paragraph;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public List<SentenceComponent> getSentenceComponentList() {
        return sentenceComponentList;
    }

    public void setSentenceComponentList(List<SentenceComponent> sentenceComponentList) {
        this.sentenceComponentList = sentenceComponentList;
    }
}
